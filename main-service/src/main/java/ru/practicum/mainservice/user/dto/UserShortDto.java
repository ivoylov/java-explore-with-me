package ru.practicum.mainservice.user.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Builder
@Getter
public class UserShortDto {
    private Long id;
    @NotEmpty
    private String name;
}
