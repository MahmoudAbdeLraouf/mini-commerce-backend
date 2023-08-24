package vatix.minicommerce.Payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryTranslationDto {

	public CategoryTranslationDto(String lang, String value) {
		this.lang = lang;
		this.value = value;
	}
	@NotBlank(message = "The Lang key is required")
	@Size(min = 2, max = 100, message = "The length of Category name must be between 2 and 100 characters.")
	public String lang;
	@NotBlank(message = "The Category name is required")
	@Size(min = 2, max = 100, message = "The length of Category name must be between 2 and 100 characters.")
	public String value;
}
