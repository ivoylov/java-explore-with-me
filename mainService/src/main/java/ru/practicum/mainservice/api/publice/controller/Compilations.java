package ru.practicum.mainservice.api.publice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.mainservice.api.publice.service.CompilationsService;

@RestController("PubliceCompilationsController")
@Slf4j
@RequestMapping("/compilations")
public class Compilations {

    CompilationsService compilationsService;

    @GetMapping
    public void getAll() {
        compilationsService.getAll();
    }

    @GetMapping("{compId}")
    public void get() {
        compilationsService.get();
    }

}
