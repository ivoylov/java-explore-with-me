package ru.practicum.mainservice.request.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainservice.request.EventRequestService;
import ru.practicum.mainservice.request.dto.ParticipationRequestDto;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class PrivateRequestController {

    private final EventRequestService requestService;

    @GetMapping("/{userId}/requests")
    public List<ParticipationRequestDto> participantGetRequests(
            @PathVariable Long userId
    ) {
        log.info("GET /users/{}/requests - " +
                "Getting information about the current user's " +
                "requests to participate in other people's events.", userId);
        return requestService.participantGetRequests(userId);
    }

    @PostMapping("/{userId}/requests")
    @ResponseStatus(HttpStatus.CREATED)
    public ParticipationRequestDto participantAddRequest(
            @PathVariable long userId,
            @RequestParam long eventId
    ) {
        log.info("POST /users/{}/requests?eventId={} - " +
                "Adding a request from the current user to participate in the event..", userId, eventId);
        return requestService.participantAddRequest(userId, eventId);
    }

    @PatchMapping("/{userId}/requests/{requestId}/cancel")
    public ParticipationRequestDto participantCancelRequest(
            @PathVariable long userId,
            @PathVariable long requestId
    ) {
        log.info("PATCH /users/{}/requests/{}/cancel - " +
                "Cancellation of your request to participate in the event.", userId, requestId);

        return requestService.participantCancelRequest(userId, requestId);
    }

}
