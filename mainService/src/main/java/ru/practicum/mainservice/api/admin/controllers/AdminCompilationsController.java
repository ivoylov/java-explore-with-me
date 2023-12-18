package ru.practicum.mainservice.api.admin.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainservice.api.admin.services.CompilationsService;

@RestController("AdminCompilationsController")
@Slf4j
@RequestMapping("/admin/compilations")
public class AdminCompilationsController {

    CompilationsService compilationsService;

    @PostMapping
    public void create() {
        compilationsService.create();
    }

    @PatchMapping("/{compId}")
    public void change() {
        compilationsService.change();
    }

    @DeleteMapping("/{compId}")
    public void delete() {
        compilationsService.delete();
    }

}
