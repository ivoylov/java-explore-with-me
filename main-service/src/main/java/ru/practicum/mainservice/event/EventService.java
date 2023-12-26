package ru.practicum.mainservice.event;

import ru.practicum.mainservice.event.dto.*;
import ru.practicum.mainservice.event.dto.params.FindEventAdminParam;
import ru.practicum.mainservice.event.dto.params.FindEventPublicParam;
import ru.practicum.mainservice.request.dto.ParticipationRequestDto;

import java.util.List;

public interface EventService {

    List<EventShortDto> initiatorGetEvents(long userId, int from, int size);

    EventFullDto initiatorAddEvent(long userId, NewEventDto newEventDto);

    EventFullDto initiatorGetEvent(long userId, long eventId);

    EventFullDto initiatorUpdateEvent(long userId, long eventId,
                                      UpdateEventUserRequest updateEventUserRequest);

    List<ParticipationRequestDto> initiatorGetEventRequests(long userId, long eventId);

    EventRequestStatusUpdateResult initiatorChangeRequestStatus(long userId, long eventId,
                                                                EventRequestStatusUpdateRequest updateRequest);

    List<EventFullDto> adminFindEvents(FindEventAdminParam param);

    EventFullDto adminUpdateEvent(long eventId, UpdateEventAdminRequest updateEvent);

    List<EventShortDto> publicFindEvents(FindEventPublicParam param);

    EventFullDto publicGetEvent(long eventId);

}
