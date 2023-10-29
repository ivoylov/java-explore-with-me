package ru.practicum.mainservice.publice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/compilations")
public class Compilations {

    @GetMapping
    public void getAll() {

    }

    @GetMapping("{compId}")
    public void get() {

    }

}
