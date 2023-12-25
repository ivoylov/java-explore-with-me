package ru.practicum.mainservice.event.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Location {
    private double lat;
    private double lon;
}
