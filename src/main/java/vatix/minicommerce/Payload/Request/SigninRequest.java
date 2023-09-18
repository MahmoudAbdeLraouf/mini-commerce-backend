package vatix.minicommerce.Payload.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SigninRequest {
    @NotBlank(message = "The email is required")
    @Size(min = 2, max = 100, message = "The length of email must be between 2 and 100 characters.")
    private String email;
    @NotBlank(message = "The password is required")
    @Size(min = 2, max = 100, message = "The length of password must be between 2 and 100 characters.")
    private String password;
}