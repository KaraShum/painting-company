package de.school.paintingcompany.service;

import de.school.paintingcompany.dao.request.SignInRequest;
import de.school.paintingcompany.dao.request.SignUpRequest;
import de.school.paintingcompany.dao.response.JwtAuthenticationResponse;
import org.springframework.stereotype.Component;

@Component
public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}
