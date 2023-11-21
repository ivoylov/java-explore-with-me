package ru.practicum.mainservice.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Hit {
    Long id;
    String app;
    String uri;
    String ip;
    LocalDateTime timestamp;
}
