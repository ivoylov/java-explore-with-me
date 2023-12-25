package ru.practicum.mainservice.location.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.mainservice.event.dto.Location;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationShortDto {
    Long id;
    Location location;
    Long radius;
    String name;
}
