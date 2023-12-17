package ru.practicum.mainservice.api.admin.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainservice.api.admin.services.CategoriesService;
import ru.practicum.mainservice.models.category.Category;
import ru.practicum.mainservice.models.category.CategoryDtoIn;
import ru.practicum.mainservice.models.category.CategoryDtoOut;
import ru.practicum.mainservice.models.category.CategoryMapper;

@RestController("AdminCategoriesController")
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/admin/categories")
public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;

    @PostMapping
    public CategoryDtoOut create(@RequestBody CategoryDtoIn categoryDtoIn) {
        Category category = CategoryMapper.toCategory(categoryDtoIn);
        return CategoryMapper.toCategoryDtoOut(categoriesService.create(category));
    }

    @PatchMapping("/{catId}")
    public void change() {
        categoriesService.change();
    }

    @DeleteMapping("/{catId}")
    public void delete() {
        categoriesService.delete();
    }

}
