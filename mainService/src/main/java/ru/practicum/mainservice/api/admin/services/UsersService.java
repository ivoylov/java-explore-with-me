package ru.practicum.mainservice.api.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.mainservice.api.admin.repositories.UserRepository;
import ru.practicum.mainservice.exceptions.ConflictException;
import ru.practicum.mainservice.exceptions.NotFoundException;
import ru.practicum.mainservice.models.user.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service("AdminUsersService")
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new ConflictException("Пользователь уже существует", e.getMessage());
        }
    }

    public User getById(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    public List<User> getAll(Pageable pageable, List<Long> ids) {
        if(ids.size() != 0) {
            return userRepository.findAllById(ids);
        } else
            return userRepository.findAll(pageable).getContent();
    }

    public void delete(Long userId) {
        try {
            userRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(String.format("пользователь с id=%s не найден", userId));
        }
    }

}
