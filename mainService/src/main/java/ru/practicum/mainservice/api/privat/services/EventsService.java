package ru.practicum.mainservice.api.privat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.mainservice.api.privat.repositories.EventRepository;
import ru.practicum.mainservice.models.event.Event;

@Service("PrivatEventsService")
public class EventsService {

    @Autowired
    EventRepository eventRepository;

    public Event create(Event event) {
        return eventRepository.save(event);
    }

    public void get() {

    }

    public void getAll() {

    }

    public void change() {

    }

    public void getRequests() {

    }

    public void changeRequest() {

    }

}
