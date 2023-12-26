package ru.practicum.mainservice.location.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.mainservice.event.dto.Location;
import ru.practicum.mainservice.location.LocationStatusAction;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateLocationRequest {
    Location location;
    @Min(1)
    Long radius;
    @Size(min = 3, max = 250)
    String name;
    LocationStatusAction action;
}
