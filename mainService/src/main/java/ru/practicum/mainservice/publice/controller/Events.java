package ru.practicum.mainservice.publice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/events")
public class Events {


    @GetMapping
    public void getAll() {

    }

    @GetMapping("/{id}")
    public void get() {

    }

}
