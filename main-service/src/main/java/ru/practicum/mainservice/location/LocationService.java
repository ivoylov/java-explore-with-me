package ru.practicum.mainservice.location;

import ru.practicum.mainservice.location.dto.*;

import java.util.List;

public interface LocationService {

    List<LocationFullDto> adminFindLocations(List<LocationStatus> statuses, int from, int size);

    LocationDto adminCreateLocation(NewLocationDto newLocationDto);

    LocationDto adminUpdateLocation(long locationId, UpdateLocationRequest locationRequest);

    void adminDeleteLocation(long locationId);

    LocationDto initiatorAddLocation(long userId, NewLocationDto newLocationDto);

    List<LocationDto> findAllLocations(int from, int size);

    LocationEventsDto findEventsInLocation(long locationId, int from, int size);

}
