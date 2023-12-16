package ru.practicum.mainservice.models.event;

import lombok.experimental.UtilityClass;
import ru.practicum.mainservice.models.Location;
import ru.practicum.mainservice.models.user.UserMapper;

@UtilityClass
public class EventMapper {

    public Event toEvent(EventDtoIn eventDtoIn) {
        return Event.builder()
                .title(eventDtoIn.getTitle())
                .annotation(eventDtoIn.getAnnotation())
                .description(eventDtoIn.getDescription())
                .eventDate(eventDtoIn.getEventDate())
                .participantLimit(eventDtoIn.getParticipantLimit())
                .paid(eventDtoIn.getPaid())
                .lat(eventDtoIn.getLocation().getLat())
                .lon(eventDtoIn.getLocation().getLon())
                .requestModeration(eventDtoIn.getRequestModeration())
                .build();
    }

    public EventDtoOut toEventDtoOut(Event event) {
        return EventDtoOut.builder()
                .id(event.getId())
                .title(event.getTitle())
                .annotation(event.getAnnotation())
                .description(event.getDescription())
                .eventDate(event.getEventDate())
                .participantLimit(event.getParticipantLimit())
                .paid(event.getPaid())
                .location(new Location(event.getLat(), event.getLon()))
                .requestModeration(event.getRequestModeration())
                .initiator(UserMapper.toUserDtoOutShort(event.getInitiator()))
                .build();
    }

}
