package ru.practicum.mainservice.privat.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("users/{userId}/events")
public class Events {

    @PostMapping
    public void create() {

    }

    @PatchMapping("{eventId}")
    public void change() {

    }

    @GetMapping("{eventId}")
    public void get() {

    }


    @GetMapping
    public void getAll() {

    }

    @GetMapping("/requests")
    public void getRequests() {

    }

    @PatchMapping("/requests")
    public void changeRequest() {

    }

}
