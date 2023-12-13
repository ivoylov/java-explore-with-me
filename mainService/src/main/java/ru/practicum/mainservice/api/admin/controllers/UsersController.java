package ru.practicum.mainservice.api.admin.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainservice.api.admin.services.UsersService;
import ru.practicum.mainservice.models.user.User;
import ru.practicum.mainservice.models.user.UserDtoIn;
import ru.practicum.mainservice.models.user.UserDtoOut;
import ru.practicum.mainservice.models.user.UserMapper;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.List;

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
    public List<User> getAll(@RequestParam(defaultValue = "0") Integer from,
                             @RequestParam(defaultValue = "10") Integer size) {
        return usersService.getAll(PageRequest.of(from,size));
    }

    @DeleteMapping("/{userId}")
    public void delete() {
        usersService.delete();
    }

}
