package ru.practicum.mainservice.api.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.practicum.mainservice.api.admin.repositories.CategoryRepository;
import ru.practicum.mainservice.exceptions.ConflictException;
import ru.practicum.mainservice.exceptions.NotFoundException;
import ru.practicum.mainservice.models.category.Category;

import javax.transaction.Transactional;
import java.util.List;

@Service("AdminCategoriesService")
public class CategoriesService {

    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public Category create(Category category) {
        try {
            return categoryRepository.save(category);
        } catch (DataIntegrityViolationException e) {
            throw new ConflictException("Категория уже существует", e.getMessage());
        }
    }

    @Transactional
    public Category change(Category oldCategory, Long catId) {
        Category newCategory = categoryRepository.findById(catId)
                .orElseThrow(() -> new NotFoundException(String.format("Категория с id=%d не найдена", catId)));
        newCategory.setName(oldCategory.getName());
        try {
            return categoryRepository.save(newCategory);
        } catch (DataAccessException e) {
            throw new ConflictException(e.getMessage(), "Категория уже существует");
        }
    }

    @Transactional
    public void delete(Long catId) {
        try {
            categoryRepository.deleteById(catId);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(String.format("Категория с id=%d не найдена", catId));
        } catch (DataIntegrityViolationException e) {
            throw new ConflictException("Невозможно удалить категорию", "С категорией связаны события");
        }
    }
    public Category findCategoryById(long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException(String.format("Категория с id=%d не найдена", categoryId)));
        return category;
    }

    public List<Category> findAllCategories(int from, int size) {
        return categoryRepository.findAll(PageRequest.of(from,size)).toList();
    }

}
