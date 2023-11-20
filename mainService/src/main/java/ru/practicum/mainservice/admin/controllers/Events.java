package ru.practicum.mainservice.admin.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController("AdminEventsController")
@RequestMapping("/admin/events")
class Events {

    @GetMapping
    public void get() {

    }

    @PatchMapping("/{eventId}")
    public void change() {

    }

}