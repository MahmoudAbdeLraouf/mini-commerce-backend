package vatix.minicommerce.Payload;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vatix.minicommerce.Model.CategoryTranslation;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto {
	public Long id;
	public boolean status;
	@Valid
	public List<CategoryTranslationDto> name;
}
