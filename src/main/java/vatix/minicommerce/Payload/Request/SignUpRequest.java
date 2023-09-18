package vatix.minicommerce.Payload.Request;

import jakarta.validation.constraints.Email;
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
public class SignUpRequest {

    @NotBlank(message = "The first name is required")
    @Size(min = 2, max = 100, message = "The length of first name must be between 2 and 100 characters.")
    private String firstName;
    @NotBlank(message = "The last name is required")
    @Size(min = 2, max = 100, message = "The length of lirst name must be between 2 and 100 characters.")
    private String lastName;
    @NotBlank(message = "The email is required")
    @Size(min = 2, max = 100, message = "The length of email must be between 2 and 100 characters.")
    @Email
    private String email;
    @NotBlank(message = "The password is required")
    @Size(min = 2, max = 100, message = "The length of password must be between 2 and 100 characters.")
    private String password;
}