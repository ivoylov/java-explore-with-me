package ru.practicum.mainservice.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatDtoOut {
    String app;
    List<String> uri;
    Integer hits;
}
