package ru.practicum.mainservice.api.admin.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.mainservice.api.admin.repositories.UserRepository;
import ru.practicum.mainservice.models.user.User;

import java.util.List;

@Service("AdminUsersService")
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void delete() {
    }

}
