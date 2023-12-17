package ru.practicum.mainservice.api.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.mainservice.api.admin.repositories.CategoryRepository;
import ru.practicum.mainservice.models.category.Category;

@Service("AdminCategoriesService")
public class CategoriesService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public void change() {

    }

    public void delete() {

    }

}
