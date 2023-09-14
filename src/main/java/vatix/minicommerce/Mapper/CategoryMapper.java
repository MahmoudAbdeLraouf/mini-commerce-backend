package vatix.minicommerce.Mapper;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import vatix.minicommerce.Model.Category;
import vatix.minicommerce.Model.CategoryTranslation;
import vatix.minicommerce.Payload.CategoryDto;
import vatix.minicommerce.Payload.CategoryTranslationDto;
import vatix.minicommerce.Mapper.CategoryTranslationMapper;

public class CategoryMapper {
	
	  // Convert Category JPA Entity into CategoryDto
    public static CategoryDto mapToCategoryDto(Category category){    	
		List<CategoryTranslation> categoryTranslations = category.getTranslations();
        CategoryDto categoryDto = new CategoryDto(
        	category.id,
        	category.status,
        	categoryTranslations.stream().map(CategoryTranslationMapper::mapToCategoryTranslationDto).collect(Collectors.toList())       	
        );
        return categoryDto;
    }

    // Convert CategoryDto into Category JPA Entity
    public static Category mapToCategory(CategoryDto categoryDto){
        List<CategoryTranslationDto> categoryTranslationDto = categoryDto.name;
    	Category category = new Category(
    		categoryDto.status,
        	categoryTranslationDto.stream().map(CategoryTranslationMapper::mapToCategoryTranslation).collect(Collectors.toList())
        );
//    	Category category = new Category(
//        		categoryDto.status
//            );
    	category.getTranslations().forEach(translation->translation.setCategory(category));
        return category;
    }
}
