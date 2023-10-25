package ru.practicum.statisticservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.statisticservice.Create;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HitDtoIn {
    @NotBlank(groups = Create.class, message = "app не может быть пустым")
    private String app;
    @NotBlank(groups = Create.class, message = "uri не может быть пустым")
    private String uri;
    @NotBlank(groups = Create.class, message = "ip не может быть пустым")
    private String ip;
    @NotNull(groups = Create.class, message = "timestamp не может быть пустым")
    private String timestamp;
}
