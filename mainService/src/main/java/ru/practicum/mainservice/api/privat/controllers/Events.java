package ru.practicum.mainservice.api.privat.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainservice.api.privat.services.EventsService;
import ru.practicum.mainservice.models.event.Event;
import ru.practicum.mainservice.models.event.EventDtoIn;
import ru.practicum.mainservice.models.event.EventDtoOut;
import ru.practicum.mainservice.models.event.EventMapper;

import javax.validation.Valid;

@Slf4j
@RestController("PrivateEventsController")
@RequestMapping("/users/{userId}/events")
public class Events {

    @Autowired
    EventsService eventsService;

    @PostMapping
    public EventDtoOut create(@PathVariable Long userId, @Valid @RequestBody EventDtoIn eventDtoIn) {
        Event event = EventMapper.toEvent(eventDtoIn);
        return EventMapper.toEventDtoOut(eventsService.create(event, userId));
    }

    @GetMapping("{eventId}")
    public void get() {
        eventsService.get();
    }

    @GetMapping
    public void getAll() {
        eventsService.getAll();
    }

    @PatchMapping("/{eventId}")
    public void change() {
        eventsService.change();
    }

    @GetMapping("/requests")
    public void getRequests() {
        eventsService.getRequests();
    }

    @PatchMapping("/requests")
    public void changeRequest() {
        eventsService.changeRequest();
    }

}
