package ru.practicum.mainservice.api.admin.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainservice.api.admin.services.UsersService;

@RestController("AdminUsersController")
@Slf4j
@RequestMapping("/admin/users")
public class Users {

    UsersService usersService;

    @PostMapping
    public void create() {
        usersService.create();
    }

    @GetMapping
    public void getAll() {
        usersService.getAll();
    }

    @DeleteMapping("/{userId}")
    public void delete() {
        usersService.delete();
    }

}
