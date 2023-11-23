package ru.practicum.mainservice.api.admin.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.practicum.mainservice.api.admin.repositories.UserRepository;
import ru.practicum.mainservice.models.user.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UsersServiceTest {

    @InjectMocks
    static UsersService userService;

    @Mock
    static UserRepository userRepository;

    @Test
    void whenCorrectUser_thenGetUserWithIdOne() {
        User user = User.builder()
                .name("name")
                .email("email@mail.ru")
                .build();
        User gottenUser = new User(1L, "name", "email@mail.ru");
        Mockito.when(userRepository.save(any())).thenReturn(gottenUser);
        assertEquals(gottenUser, userService.create(user));
    }

    @Test
    void getAll() {
    }

    @Test
    void delete() {
    }

}