package ru.practicum.mainservice.api.admin.services;

import org.springframework.stereotype.Service;
import ru.practicum.mainservice.models.user.User;

@Service("AdminUsersService")
public class UsersService {
    public User create(User user) {
        return user;
    }

    public void getAll() {
    }

    public void delete() {

    }

}
