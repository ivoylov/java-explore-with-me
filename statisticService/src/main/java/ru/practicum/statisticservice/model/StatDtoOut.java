package ru.practicum.statisticservice.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatDtoOut {
    String app;
    String uri;
    Integer hits;
}
