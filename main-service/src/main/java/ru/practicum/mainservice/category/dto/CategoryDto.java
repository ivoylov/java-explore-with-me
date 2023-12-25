package ru.practicum.mainservice.category.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
public class CategoryDto {
    private Long id;

    @Size(min = 1, max = 50)
    private String name;
}
