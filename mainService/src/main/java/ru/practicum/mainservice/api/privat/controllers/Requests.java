package ru.practicum.mainservice.api.privat.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainservice.api.privat.services.RequestsService;

@RestController("PrivateRequestsController")
@Slf4j
@RequestMapping("users/{userId}/requests")
public class Requests {

    RequestsService requestsService;

    @GetMapping
    public void get() {
        requestsService.get();
    }

    @PostMapping
    public void create() {
        requestsService.create();
    }

    @DeleteMapping("/requestId/cancel")
    public void delete() {
        requestsService.delete();
    }

}
