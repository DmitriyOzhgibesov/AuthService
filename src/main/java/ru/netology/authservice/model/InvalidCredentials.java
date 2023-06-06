package ru.netology.authservice.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String msg) {
        try {
            throw new RuntimeException(msg);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, msg, ex);
        }
    }
}