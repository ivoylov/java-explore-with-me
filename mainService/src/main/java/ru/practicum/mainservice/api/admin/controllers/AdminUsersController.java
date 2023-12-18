package ru.practicum.mainservice.api.admin.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainservice.api.admin.services.UsersService;
import ru.practicum.mainservice.models.user.User;
import ru.practicum.mainservice.models.user.UserDtoIn;
import ru.practicum.mainservice.models.user.UserDtoOut;
import ru.practicum.mainservice.models.user.UserMapper;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController("AdminUsersController")
@Slf4j
@RequestMapping("/admin/users")
public class AdminUsersController {

    @Autowired
    UsersService usersService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDtoOut create(@Valid @RequestBody UserDtoIn userDtoIn) {
        User user = UserMapper.toUser(userDtoIn);
        return UserMapper.toUserDtoOut(usersService.create(user));
    }

    @GetMapping
    public List<User> getAll(@RequestParam(required = false) List<Long> ids,
                             @RequestParam(defaultValue = "0") @PositiveOrZero int from,
                             @RequestParam(defaultValue = "10") @Positive int size) {
        return usersService.getAll(PageRequest.of(from,size), ids);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId) {
        usersService.delete(userId);
    }

}
