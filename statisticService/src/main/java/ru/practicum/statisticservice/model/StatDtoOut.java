package ru.practicum.statisticservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatDtoOut {
    private String app;
    private String[] uris;
    private Integer hits;
}
