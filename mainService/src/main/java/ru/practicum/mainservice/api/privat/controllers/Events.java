package ru.practicum.mainservice.api.privat.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainservice.api.privat.services.EventsService;

@Slf4j
@RestController("PrivateEventsController")
@RequestMapping("/users/{userId}/events")
public class Events {

    EventsService eventsService;

    @PostMapping
    public void create() {
        eventsService.create();
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
