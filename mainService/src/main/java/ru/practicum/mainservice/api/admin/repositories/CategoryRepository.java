package ru.practicum.mainservice.api.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.mainservice.models.category.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
