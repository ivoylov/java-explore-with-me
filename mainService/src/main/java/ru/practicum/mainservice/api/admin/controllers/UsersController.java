package ru.practicum.mainservice.api.admin.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainservice.api.admin.services.UsersService;
import ru.practicum.mainservice.models.user.User;
import ru.practicum.mainservice.models.user.UserDtoIn;
import ru.practicum.mainservice.models.user.UserDtoOut;
import ru.practicum.mainservice.models.user.UserMapper;

import javax.validation.Valid;

@RestController("AdminUsersController")
@Slf4j
@RequestMapping("/admin/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping
    public UserDtoOut create(@Valid @RequestBody UserDtoIn userDtoIn) {
        User user = UserMapper.toUser(userDtoIn);
        return UserMapper.toUserDtoOut(usersService.create(user));
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
