package ru.practicum.mainservice.request.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.mainservice.request.RequestStatus;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParticipationRequestDto {
    LocalDateTime created;
    Long event;
    Long id;
    Long requester;
    RequestStatus status;
}
