package ru.practicum.mainservice.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.mainservice.Create;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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
    LocalDateTime timestamp;
}
