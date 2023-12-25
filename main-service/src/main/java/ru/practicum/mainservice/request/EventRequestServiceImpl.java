package ru.practicum.mainservice.request;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.practicum.mainservice.event.Event;
import ru.practicum.mainservice.event.EventRepository;
import ru.practicum.mainservice.event.EventState;
import ru.practicum.mainservice.exceptions.ConflictException;
import ru.practicum.mainservice.exceptions.NotFoundException;
import ru.practicum.mainservice.request.dto.ParticipationRequestDto;
import ru.practicum.mainservice.user.User;
import ru.practicum.mainservice.user.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventRequestServiceImpl implements EventRequestService {

    final EventRequestRepository requestRepository;
    final UserRepository userRepository;
    final EventRepository eventRepository;

    @Override
    public List<ParticipationRequestDto> participantGetRequests(long userId) {
        User requester = getUser(userId);

        List<EventRequest> requestList = requestRepository.findAllByRequester(requester);
        return EventRequestMapper.eventRequestToParticipationRequestDto(requestList);
    }

    @Override
    public ParticipationRequestDto participantAddRequest(long userId, long eventId) {
        User requestor = getUser(userId);
        Event event = getEvent(eventId);

        long confirmedCount = event.getConfirmedRequests();

        if (event.getParticipantLimit() != 0 &&
                event.getParticipantLimit() <= confirmedCount) {
            throw new ConflictException("The participant limit has been reachedThe participant limit has been reached",
                    "For the requested operation the conditions are not met.");
        }

        if (!event.getState().equals(EventState.PUBLISHED)) {
            throw new ConflictException("You cannot participate in an unpublished event.",
                    "Integrity constraint has been violated.");
        }

        if (Objects.equals(event.getUser().getId(), requestor.getId())) {
            throw new ConflictException("The initiator of the event cannot add a request to participate in his event.",
                    "Integrity constraint has been violated.");
        }

        RequestStatus requestStatus = RequestStatus.PENDING;
        if (!event.getRequestModeration() || event.getParticipantLimit() == 0) {
            requestStatus = RequestStatus.CONFIRMED;
            event.setConfirmedRequests(++confirmedCount);
        }

        EventRequest eventRequest = EventRequest.builder()
                .created(LocalDateTime.now())
                .event(event)
                .requester(requestor)
                .status(requestStatus)
                .build();

        try {
            EventRequest saved = requestRepository.save(eventRequest);
            return EventRequestMapper.eventRequestToParticipationRequestDto(saved);
        } catch (DataIntegrityViolationException e) {
            throw new ConflictException("The integrity constraint has been violated.", e.getMessage());
        }

    }

    @Override
    public ParticipationRequestDto participantCancelRequest(long userId, long requestId) {
        EventRequest eventRequest = requestRepository.findFirstByIdAndRequesterId(requestId, userId)
                .orElseThrow(() -> new NotFoundException(String.format("Request with id=%d not found.",
                        userId)));

        eventRequest.setStatus(RequestStatus.CANCELED);

        EventRequest updated = requestRepository.save(eventRequest);
        return EventRequestMapper.eventRequestToParticipationRequestDto(updated);
    }

    private User getUser(long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(String.format("User with id=%d not found.",
                        userId)));
    }

    private Event getEvent(long eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new NotFoundException(String.format("Event with id=%d not found.",
                        eventId)));
    }

}
