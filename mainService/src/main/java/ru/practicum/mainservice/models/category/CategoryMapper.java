package ru.practicum.mainservice.models.category;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public Category toCategory(CategoryDtoIn categoryDtoIn) {
        return Category.builder()
                .name(categoryDtoIn.getName())
                .build();
    }

    public CategoryDtoOut toCategoryDtoOut(Category category) {
        return CategoryDtoOut.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

}
