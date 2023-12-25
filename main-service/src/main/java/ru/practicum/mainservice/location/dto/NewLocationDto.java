package ru.practicum.mainservice.location.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.practicum.mainservice.event.dto.Location;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewLocationDto {
    @NotNull
    Location location;
    @Min(1)
    Long radius;
    @NotBlank
    @Size(min = 3, max = 250)
    String name;
}
