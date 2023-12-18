package ru.practicum.mainservice.api.admin.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainservice.api.admin.services.CategoriesService;
import ru.practicum.mainservice.models.category.Category;
import ru.practicum.mainservice.models.category.CategoryDtoIn;
import ru.practicum.mainservice.models.category.CategoryDtoOut;
import ru.practicum.mainservice.models.category.CategoryMapper;

import javax.validation.Valid;

@RestController("AdminCategoriesController")
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/admin/categories")
public class AdminCategoriesController {

    @Autowired
    CategoriesService categoriesService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDtoOut create(@RequestBody @Valid CategoryDtoIn categoryDtoIn) {
        Category category = CategoryMapper.toCategory(categoryDtoIn);
        return CategoryMapper.toCategoryDtoOut(categoriesService.create(category));
    }

    @PatchMapping("/{catId}")
    public CategoryDtoOut change(@RequestBody @Valid CategoryDtoIn categoryDtoIn,
                       @PathVariable Long catId) {
        Category category = CategoryMapper.toCategory(categoryDtoIn);
        return CategoryMapper.toCategoryDtoOut(categoriesService.change(category, catId));
    }

    @DeleteMapping("/{catId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long catId) {
        categoriesService.delete(catId);
    }

}
