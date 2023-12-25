package ru.practicum.mainservice.user.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Builder
@Getter
public class UserDto {
    private Long id;
    @NotNull
    private String email;
    @NotNull
    private String name;
}
