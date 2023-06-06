package ru.netology.authservice.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String msg) {
        try {
            throw new RuntimeException(msg);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, msg, ex);
        }
    }
}