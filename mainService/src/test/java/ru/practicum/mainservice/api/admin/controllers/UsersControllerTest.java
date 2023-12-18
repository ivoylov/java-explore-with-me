package ru.practicum.mainservice.api.admin.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.practicum.mainservice.api.admin.services.UsersService;
import ru.practicum.mainservice.models.user.User;
import ru.practicum.mainservice.models.user.UserDtoIn;
import ru.practicum.mainservice.models.user.UserDtoOut;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UsersControllerTest {

    @InjectMocks
    AdminUsersController usersController;

    @Mock
    UsersService usersService;

    @Test
    void whenInputCorrectUser_thenGetCorrectUser() {
        UserDtoIn userDtoIn = new UserDtoIn("name", "email@mail.ru");
        User user = new User(1L, "name", "email@mail.ru");
        UserDtoOut userDtoOut = new UserDtoOut(1L, "name", "email@mail.ru");
        Mockito.when(usersService.create(any())).thenReturn(user);
        assertEquals(usersController.create(userDtoIn), userDtoOut);
    }

    @Test
    void whenInputUserWithIncorrectEmail_thenGetError() {
        UserDtoIn userDtoIn1 = new UserDtoIn("name", "");
        UserDtoIn userDtoIn2 = new UserDtoIn("name", "email@mailru");
        UserDtoIn userDtoIn3 = new UserDtoIn("name", "emailmail.ru");
        UserDtoIn userDtoIn4 = new UserDtoIn("name", "emailmail");
        UserDtoIn userDtoIn5 = new UserDtoIn("name", "email@mail");
        UserDtoIn userDtoIn6 = new UserDtoIn("name", "email@mail.");
        assertThrows(Exception.class, () -> usersController.create(userDtoIn1));
        assertThrows(Exception.class, () -> usersController.create(userDtoIn2));
        assertThrows(Exception.class, () -> usersController.create(userDtoIn3));
        assertThrows(Exception.class, () -> usersController.create(userDtoIn4));
        assertThrows(Exception.class, () -> usersController.create(userDtoIn5));
        assertThrows(Exception.class, () -> usersController.create(userDtoIn6));
    }

    @Test
    void whenInputWithIncorrectName_thenGetError() {
        UserDtoIn userDtoIn1= new UserDtoIn("", "email@mail.ru");
        UserDtoIn userDtoIn2 = new UserDtoIn(" ", "email@mail.ru");
        assertThrows(Exception.class, () -> usersController.create(userDtoIn1));
        assertThrows(Exception.class, () -> usersController.create(userDtoIn2));
    }

    @Test
    void getAll() {
    }

    @Test
    void delete() {
    }

}