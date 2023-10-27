package ru.practicum.mainservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults
public class StatDtoOut {
    String app;
    List<String> uri;
    Integer hits;
}
