package ru.practicum.mainservice.api.publice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.mainservice.api.publice.service.EventsService;

@Slf4j
@RestController("PubliceEventsController")
@RequestMapping("/events")
public class Events {

    EventsService eventsService;

    @GetMapping
    public void getAll() {
        eventsService.getAll();
    }

    @GetMapping("/{id}")
    public void get() {
        eventsService.get();
    }

}
