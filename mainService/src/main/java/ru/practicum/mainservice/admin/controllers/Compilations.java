package ru.practicum.mainservice.admin.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/admin/compilations")
public class Compilations {

    @PostMapping
    public void create() {

    }

    @PatchMapping("/{compId}")
    public void change() {

    }

    @DeleteMapping("/{compId}")
    public void delete() {

    }

}