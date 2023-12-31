package ru.practicum.mainservice.event.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.common.EndpointHitDto;
import ru.practicum.mainservice.event.EventService;
import ru.practicum.mainservice.event.EventSort;
import ru.practicum.mainservice.event.dto.EventFullDto;
import ru.practicum.mainservice.event.dto.EventShortDto;
import ru.practicum.mainservice.event.dto.params.FindEventPublicParam;
import ru.practicum.mainservice.exceptions.BadRequestException;
import ru.practicum.mainservice.services.StatsService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

import static ru.practicum.mainservice.utils.Util.DATE_TIME_FORMATTER;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class PublicEventController {

    private final EventService eventService;
    private final StatsService statsService;

    @GetMapping
    public List<EventShortDto> publicFindEvents(
            @RequestParam(required = false) String text,
            @RequestParam(required = false) List<Long> categories,
            @RequestParam(required = false) Boolean paid,
            @RequestParam(required = false) String rangeStart,
            @RequestParam(required = false) String rangeEnd,
            @RequestParam(defaultValue = "false") boolean onlyAvailable,
            @RequestParam(defaultValue = "EVENT_DATE") EventSort sort,
            @RequestParam(defaultValue = "0") @PositiveOrZero int from,
            @RequestParam(defaultValue = "10") @Positive int size,
            HttpServletRequest request
    ) {
        System.out.println(request.getRequestURI());
        LocalDateTime start = decodedDateTime(rangeStart);
        LocalDateTime end = decodedDateTime(rangeEnd);

        if (start != null && end != null && start.isAfter(end)) {
            throw new BadRequestException("The start date must not be later than the end date");
        }

        if (text != null) {
            text = URLDecoder.decode(text, StandardCharsets.UTF_8);
        }

        log.info("GET /events?test={}&categories={}&paid={}&rangeStart={}" +
                        "&rangeEnd={}&onlyAvailable={}&sort={}&from={}&size={} - " +
                        "Receiving events with the possibility of filtering.", text, categories, paid, rangeStart,
                rangeEnd, onlyAvailable, sort, from, size);

        FindEventPublicParam param = new FindEventPublicParam(text, categories, paid, start,
                end, onlyAvailable, sort, from, size);

        List<EventShortDto> list = eventService.publicFindEvents(param);
        EndpointHitDto hitDto = EndpointHitDto.builder()
                .app("main-service")
                .ip(request.getRemoteAddr())
                .uri(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
        statsService.hit(hitDto);
        return list;
    }

    @GetMapping("/{eventId}")
    public EventFullDto publicGetEvent(
            @PathVariable long eventId,
            HttpServletRequest request
    ) {
        log.info("GET /events/{} - " +
                "Getting detailed information about a published event by its ID.", eventId);
        EventFullDto eventFullDto = eventService.publicGetEvent(eventId);
        EndpointHitDto hitDto = EndpointHitDto.builder()
                .app("main-service")
                .ip(request.getRemoteAddr())
                .uri(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
        statsService.hit(hitDto);
        return eventFullDto;
    }

    private LocalDateTime decodedDateTime(String datetime) {
        if (datetime == null) {
            return null;
        }
        return LocalDateTime.parse(URLDecoder.decode(datetime, StandardCharsets.UTF_8), DATE_TIME_FORMATTER);
    }

}
