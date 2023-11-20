package ru.practicum.mainservice.privat.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController("PrivateRequestsController")
@Slf4j
@RequestMapping("users/{userId}/requests")
public class Requests {

    @GetMapping
    public void get() {
    }

    @PostMapping
    public void create() {

    }

    @DeleteMapping("/requestId/cancel")
    public void delete() {

    }

}
