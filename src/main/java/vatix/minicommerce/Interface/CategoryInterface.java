package vatix.minicommerce.Interface;

import java.util.List;

import vatix.minicommerce.Payload.CategoryDto;

public interface CategoryInterface {
	
	List<CategoryDto> list();
	CategoryDto store(CategoryDto categoryDto);
	CategoryDto update(CategoryDto categoryDto);
	CategoryDto display(Long id);
	void delete(Long id);
}
