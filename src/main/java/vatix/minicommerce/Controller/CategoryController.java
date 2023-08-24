package vatix.minicommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import vatix.minicommerce.Model.Category;
import vatix.minicommerce.Payload.CategoryDto;
import vatix.minicommerce.Service.CategoryService;

@RestController
@RequestMapping(path = "categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public ResponseEntity<List <CategoryDto>> list() {
			return new ResponseEntity<>(categoryService.list(), HttpStatus.OK) ;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> display(@PathVariable Long id) {
			
			return new ResponseEntity<>(categoryService.display(id), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public Object store(@Valid @RequestBody CategoryDto categoryDto) {
		return new ResponseEntity<>(categoryService.store(categoryDto), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> update(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Long id) {
		categoryDto.setId(id);
		return new ResponseEntity<>(categoryService.update(categoryDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		categoryService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK) ;
	}
	
}
