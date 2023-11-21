package ru.practicum.mainservice.api.publice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.mainservice.api.publice.service.CategoriesService;


@RestController("PubliceCategoriesController")
@Slf4j
@RequestMapping("/categories")
public class Categories {

    CategoriesService categoriesService;

    @GetMapping
    public void getAll() {
        categoriesService.getAll();
    }

    @GetMapping("/{catId}")
    public void get() {
        categoriesService.get();
    }

}
