package ru.practicum.statisticservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HitDtoIn {
    @NotNull(message = "app не может быть null")
    private String app;
    @NotNull(message = "uri не может быть null")
    private String uri;
    @NotNull(message = "ip не может быть null")
    private String ip;
    @NotNull(message = "timestamp не может быть null")
    private String timestamp;
}
