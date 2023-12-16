package ru.practicum.mainservice.api.privat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.mainservice.api.admin.services.UsersService;
import ru.practicum.mainservice.api.privat.repositories.EventRepository;
import ru.practicum.mainservice.models.event.Event;
import ru.practicum.mainservice.models.user.User;

@Service("PrivatEventsService")
public class EventsService {

    @Autowired
    EventRepository eventRepository;
    @Autowired
    UsersService usersService;

    public Event create(Event event, Long userId) {
        User initiator = usersService.getById(userId);
        event.setInitiator(initiator);
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
