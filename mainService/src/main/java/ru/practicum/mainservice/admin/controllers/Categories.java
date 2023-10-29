package ru.practicum.mainservice.admin.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/admin/categories")
public class Categories {

    @PostMapping
    public void create() {

    }

    @PatchMapping("/{catId}")
    public void change() {

    }

    @DeleteMapping("/{catId}")
    public void delete() {

    }

}
