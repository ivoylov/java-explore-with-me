package ru.practicum.mainservice.api.admin.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainservice.api.admin.services.EventsService;

@Slf4j
@RestController("AdminEventsController")
@RequestMapping("/admin/events")
class EventsController {

    EventsService eventsService;

    @GetMapping
    public void get() {
        eventsService.get();
    }

    @PatchMapping("/{eventId}")
    public void change() {
        eventsService.change();
    }

}