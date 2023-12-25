package ru.practicum.mainservice.event.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainservice.event.EventService;
import ru.practicum.mainservice.event.dto.*;
import ru.practicum.mainservice.request.dto.ParticipationRequestDto;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class PrivateEventController {

    private final EventService eventService;

    @GetMapping("/{userId}/events")
    public List<EventShortDto> initiatorGetEvents(
            @PathVariable long userId,
            @RequestParam(defaultValue = "0") @PositiveOrZero int from,
            @RequestParam(defaultValue = "10") @Positive int size
    ) {
        log.info("GET /users/{}/events - Getting events added by the current user.", userId);
        return eventService.initiatorGetEvents(userId, from, size);
    }

    @PostMapping("/{userId}/events")
    @ResponseStatus(HttpStatus.CREATED)
    public EventFullDto initiatorAddEvent(
            @PathVariable long userId,
            @RequestBody @Valid NewEventDto newEventDto
    ) {
        log.info("POST /users/{}/events - Adding a new event.", userId);
        return eventService.initiatorAddEvent(userId, newEventDto);
    }

    @GetMapping("/{userId}/events/{eventId}")
    public EventFullDto initiatorGetEvent(
            @PathVariable long userId,
            @PathVariable long eventId
    ) {
        log.info("GET /users/{}/events/{} - " +
                        "Getting full information about the event added by the current user.",
                userId, eventId);
        return eventService.initiatorGetEvent(userId, eventId);
    }

    @PatchMapping("/{userId}/events/{eventId}")
    public EventFullDto initiatorUpdateEvent(
            @PathVariable long userId,
            @PathVariable long eventId,
            @RequestBody @Valid UpdateEventUserRequest updateEventUserRequest
    ) {
        log.info("PATCH /users/{}/events/{} - Changing an event added by the current user.",
                userId, eventId);
        return eventService.initiatorUpdateEvent(userId, eventId, updateEventUserRequest);
    }

    @GetMapping("/{userId}/events/{eventId}/requests")
    public List<ParticipationRequestDto> initiatorGetEventRequests(
            @PathVariable long userId,
            @PathVariable long eventId
    ) {
        log.info("GET /users/{}/events/{}/requests - " +
                        "Getting information about requests to participate in the event of the current user.",
                userId, eventId);
        return eventService.initiatorGetEventRequests(userId, eventId);
    }

    @PatchMapping("/{userId}/events/{eventId}/requests")
    public EventRequestStatusUpdateResult initiatorChangeRequestStatus(
            @PathVariable long userId,
            @PathVariable long eventId,
            @RequestBody EventRequestStatusUpdateRequest updateRequest
    ) {
        log.info("PATCH /users/{}/events/{}/requests - " +
                "Changing the status (confirmed, canceled) of applications " +
                "for participation in the event of the current user.", userId, eventId);
        return eventService.initiatorChangeRequestStatus(userId, eventId, updateRequest);
    }

}
