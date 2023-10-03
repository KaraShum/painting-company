package de.school.paintingcompany.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    UserDetailsService userDetailsService();
}
