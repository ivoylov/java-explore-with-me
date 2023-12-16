package ru.practicum.mainservice.models.event;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.mainservice.models.Location;
import ru.practicum.mainservice.models.user.UserDtoOutShort;

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
    Location location;
    Boolean requestModeration;
    UserDtoOutShort initiator;
}
