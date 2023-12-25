package ru.practicum.mainservice.user.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserShortDto {
    Long id;
    @NotEmpty
    String name;
}
