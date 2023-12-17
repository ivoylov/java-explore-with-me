package ru.practicum.mainservice.api.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.mainservice.api.admin.repositories.CategoryRepository;
import ru.practicum.mainservice.models.category.Category;

import javax.transaction.Transactional;

@Service("AdminCategoriesService")
public class CategoriesService {

    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    public Category change(Category category, Long catId) {
        Category oldCategory =  categoryRepository.getReferenceById(catId);
        oldCategory.setName(category.getName());
        return oldCategory;
    }

    @Transactional
    public void delete(Long catId) {
        categoryRepository.deleteById(catId);
    }

}
