package ru.practicum.mainservice.admin.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController("AdminUsersController")
@Slf4j
@RequestMapping("/admin/users")
public class Users {


    @PostMapping
    public void create() {

    }

    @GetMapping
    public void getAll() {

    }

    @DeleteMapping("/{userId}")
    public void delete() {

    }

}
