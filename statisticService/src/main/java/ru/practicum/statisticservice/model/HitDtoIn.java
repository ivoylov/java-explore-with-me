package ru.practicum.statisticservice.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.statisticservice.Create;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HitDtoIn {
    @NotBlank(groups = Create.class, message = "app не может быть пустым")
    String app;
    @NotBlank(groups = Create.class, message = "uri не может быть пустым")
    String uri;
    @NotBlank(groups = Create.class, message = "ip не может быть пустым")
    String ip;
    @NotNull(groups = Create.class, message = "timestamp не может быть пустым")
    String timestamp;
}
