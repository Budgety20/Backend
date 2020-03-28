package com.budget.mapper

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import com.budget.service.model.Category as CategoryModel
import org.assertj.core.api.Assertions.assertThat

@SpringBootTest
class CategoryMapperTests() {
    @Test
    fun to_should_translate_single_category_model_to_dto(){
        var categoryModel = CategoryModel("C01", "Food");
        categoryModel.description = "Expenses on the food related items";
        var categories = listOf(categoryModel)

        var categoryDto = CategoryMapper.map(categories);

        assertThat(categoryDto[0].code).isEqualTo(categoryModel.code);
        assertThat(categoryDto[0].name).isEqualTo(categoryModel.name);
        assertThat(categoryDto[0].description).isEqualTo(categoryModel.description);
    }

    @Test
    fun to_should_translate_multiple_category_model_to_dto(){
        var categoryModels = getDummyCategories()

        var categoryDtos = CategoryMapper.map(categoryModels);

        assertThat(categoryDtos[0].code).isEqualTo(categoryModels[0].code);
        assertThat(categoryDtos[0].name).isEqualTo(categoryModels[0].name);
        assertThat(categoryDtos[0].description).isEqualTo(categoryModels[0].description);
        assertThat(categoryDtos[1].code).isEqualTo(categoryModels[1].code);
        assertThat(categoryDtos[1].name).isEqualTo(categoryModels[1].name);
        assertThat(categoryDtos[1].description).isEqualTo(categoryModels[1].description);
    }

    private fun getDummyCategories(): List<CategoryModel>{
        var categoryModel1 = CategoryModel("C01", "Food");
        categoryModel1.description = "Expenses on the food related items";

        var categoryModel2 = CategoryModel("C01", "Food");
        categoryModel2.description = "Expenses on the food related items";

        return listOf(categoryModel1, categoryModel2)
    }
}