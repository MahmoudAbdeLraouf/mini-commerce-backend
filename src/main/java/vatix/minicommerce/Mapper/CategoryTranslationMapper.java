package vatix.minicommerce.Mapper;

import vatix.minicommerce.Model.CategoryTranslation;
import vatix.minicommerce.Payload.CategoryTranslationDto;

public class CategoryTranslationMapper {
	
	  // Convert Category Translation JPA Entity into CategoryTranslationDto
    public static CategoryTranslationDto mapToCategoryTranslationDto(CategoryTranslation categoryTranslation){        
    	 CategoryTranslationDto categoryTranslationDto = new CategoryTranslationDto(
    	        	categoryTranslation.lang,
    	        	categoryTranslation.name
    	        );
    	return categoryTranslationDto;
    }

    // Convert CategoryDto into Category JPA Entity
    public static CategoryTranslation mapToCategoryTranslation(CategoryTranslationDto categoryTranslationDto){
        CategoryTranslation categoryTranslation = new CategoryTranslation(
        		categoryTranslationDto.lang,
        		categoryTranslationDto.value
        );
        return categoryTranslation;
    }
}
