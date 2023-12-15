package ru.practicum.mainservice.models.event;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventDtoOut {
    Long id;
    String title;
    String annotation;
    String description;
    LocalDateTime eventDate;
    Integer participantLimit;
    Boolean paid;
}
