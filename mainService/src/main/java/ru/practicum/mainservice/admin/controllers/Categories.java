package ru.practicum.mainservice.admin.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainservice.admin.CategoriesService;

@RestController("AdminCategoriesController")
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/admin/categories")
public class Categories {

    CategoriesService categoriesService;

    @PostMapping
    public void create() {
        categoriesService.create();
    }

    @PatchMapping("/{catId}")
    public void change() {

    }

    @DeleteMapping("/{catId}")
    public void delete() {

    }

}
