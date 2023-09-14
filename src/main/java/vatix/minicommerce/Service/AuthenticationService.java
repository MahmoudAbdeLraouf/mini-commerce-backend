package vatix.minicommerce.Service;

import vatix.minicommerce.Payload.Request.SignUpRequest;
import vatix.minicommerce.Payload.Request.SigninRequest;
import vatix.minicommerce.Payload.Response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}