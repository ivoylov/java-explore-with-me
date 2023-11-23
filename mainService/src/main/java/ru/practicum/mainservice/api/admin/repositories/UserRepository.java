package ru.practicum.mainservice.api.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.mainservice.models.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
