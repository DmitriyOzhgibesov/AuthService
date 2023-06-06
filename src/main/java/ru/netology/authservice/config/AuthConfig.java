package ru.netology.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.authservice.service.AuthorizationService;
import ru.netology.authservice.repository.UserRepository;

@Configuration
public class AuthConfig {
    @Bean
    public AuthorizationService authorizationService() {
        return new AuthorizationService(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}