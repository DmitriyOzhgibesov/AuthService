package ru.netology.authservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfig {
    @Bean
    public AuthorizationService authorizationService() {
        return new AuthorizationService(userRepository());
    }

    @Bean
    public AuthorizationController authorizationController() {
        return new AuthorizationController(authorizationService());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}