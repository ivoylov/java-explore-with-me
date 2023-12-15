package ru.practicum.mainservice.models.event;

import lombok.experimental.UtilityClass;

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
                .build();
    }

}
