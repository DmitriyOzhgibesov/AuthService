package ru.netology.authservice.controller;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.authservice.model.Authorities;
import ru.netology.authservice.model.InvalidCredentials;
import ru.netology.authservice.model.UnauthorizedUser;
import ru.netology.authservice.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService authorizationService) {
        this.service = authorizationService;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthHandler(UnauthorizedUser e) throws JSONException {
        JSONObject resp = new JSONObject();
        resp.put("status", HttpStatus.UNAUTHORIZED);
        resp.put("body", e.getMessage());
        System.out.println("InvalidCredentials exception! Reason: " + e.getMessage());

        return new ResponseEntity<>(resp.toString(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> brHandler(InvalidCredentials e) throws JSONException {
        JSONObject resp = new JSONObject();
        resp.put("status", HttpStatus.BAD_REQUEST);
        resp.put("body", e.getMessage());
        System.out.println("InvalidCredentials exception! Reason: " + e.getMessage());

        return new ResponseEntity<>(resp.toString(), HttpStatus.BAD_REQUEST);
    }
}