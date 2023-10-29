package ru.practicum.mainservice.admin.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/admin/events")
public class Events {

    @GetMapping
    public void get() {

    }

    @PatchMapping("/{eventId}")
    public void change() {

    }

}