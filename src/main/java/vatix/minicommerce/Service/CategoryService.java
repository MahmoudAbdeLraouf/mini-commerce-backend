package vatix.minicommerce.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vatix.minicommerce.Exception.ResourceNotFoundException;
import vatix.minicommerce.Interface.CategoryInterface;
import vatix.minicommerce.Mapper.CategoryMapper;
import vatix.minicommerce.Model.Category;
import vatix.minicommerce.Payload.CategoryDto;
import vatix.minicommerce.Repository.CategoryRepository;

@Service
public class CategoryService implements CategoryInterface{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<CategoryDto> list() {
		List<Category> categories = categoryRepository.findAll();
		return categories.stream().map(CategoryMapper::mapToCategoryDto).collect(Collectors.toList());
	}
	
	@Override
	public CategoryDto display(Long id) {
		Category category = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "id", id));
		return CategoryMapper.mapToCategoryDto(category);
	}
	
	@Override
	public CategoryDto store(CategoryDto categoryDto) {
		categoryDto.status = true;
		Category category = CategoryMapper.mapToCategory(categoryDto);
//		category.getTranslations().forEach(translation->translation.setCategory(category));
		category = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(category);

	}
	
	@Override 
	public CategoryDto update(CategoryDto categoryDto){
		Category category = categoryRepository.findById(categoryDto.getId()).orElseThrow(()-> new ResourceNotFoundException("Category", "id", categoryDto.getId()));
		category.setStatus(categoryDto.status);
        category = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(category);
	}
	
	@Override
	public void delete(Long id) {
		categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "id", id));
		categoryRepository.deleteById(id);
	}
}
