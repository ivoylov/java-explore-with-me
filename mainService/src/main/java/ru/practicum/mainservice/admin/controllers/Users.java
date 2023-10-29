package ru.practicum.mainservice.admin.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/admin/users")
public class Users {

    @GetMapping
    public void getAll() {

    }

    @PostMapping
    public void create() {

    }

    @DeleteMapping("/{userId}")
    public void delete() {

    }

}
