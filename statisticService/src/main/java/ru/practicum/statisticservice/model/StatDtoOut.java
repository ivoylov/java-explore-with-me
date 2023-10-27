package ru.practicum.statisticservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults
public class StatDtoOut {
    String app;
    String uri;
    Integer hits;
}
