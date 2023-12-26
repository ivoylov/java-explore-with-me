package ru.practicum.mainservice.location.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.mainservice.event.dto.Location;
import ru.practicum.mainservice.location.LocationStatus;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationDto {
    Long id;
    Location location;
    Long radius;
    String name;
    LocationStatus status;
}
