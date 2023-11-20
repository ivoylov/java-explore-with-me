package ru.practicum.mainservice.privat.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController("PrivateEventsController")
@RequestMapping("users/{userId}/events")
public class Events {

    @PostMapping
    public void create() {

    }

    @GetMapping("{eventId}")
    public void get() {

    }


    @GetMapping
    public void getAll() {

    }

    @PatchMapping("/{eventId}")
    public void change() {

    }

    @GetMapping("/requests")
    public void getRequests() {

    }

    @PatchMapping("/requests")
    public void changeRequest() {

    }

}
