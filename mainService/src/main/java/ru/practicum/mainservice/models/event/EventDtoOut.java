package ru.practicum.mainservice.models.event;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDtoOut {
    Long id;
    String title;
    String annotation;
    String description;
    LocalDateTime eventDate;
}
