package ru.practicum.mainservice.api.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.mainservice.api.admin.repositories.UserRepository;
import ru.practicum.mainservice.models.user.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service("AdminUsersService")
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public User getById(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    public List<User> getAll(Pageable pageable, Long[] ids) {
        if(ids.length != 0) {
            List<Long> iterable = Arrays.stream(ids)
                    .collect(Collectors.toList());
            return userRepository.findAllById(iterable);
        } else
            return userRepository.findAll(pageable).getContent();
    }

    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

}
