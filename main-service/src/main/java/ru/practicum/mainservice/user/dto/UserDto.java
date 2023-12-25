package ru.practicum.mainservice.user.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Builder
@Getter
public class UserDto {
    Long id;
    @NotNull
    String email;
    @NotNull
    String name;
}
