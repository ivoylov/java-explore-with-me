package ru.practicum.mainservice.event.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.mainservice.request.dto.ParticipationRequestDto;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventRequestStatusUpdateResult {
    List<ParticipationRequestDto> confirmedRequests;
    List<ParticipationRequestDto> rejectedRequests;
}
