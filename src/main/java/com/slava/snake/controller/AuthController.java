package com.slava.snake.controller;

import com.slava.snake.dto.AuthDto;
import com.slava.snake.dto.JwtAuthResponse;
import com.slava.snake.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> authUser(@RequestBody AuthDto auth) {
        JwtAuthResponse response = authService.login(auth);
        return response != null
                ? ResponseEntity.ok().body(response)
                : ResponseEntity.badRequest().body(null);
    }

    
    @PostMapping("/register")
    public ResponseEntity<JwtAuthResponse> registerUser(@RequestBody AuthDto auth) {
        JwtAuthResponse response = authService.register(auth);
        return response != null
                ? ResponseEntity.status(204).body(response) 
                : ResponseEntity.badRequest().body(null);
    }
    
}
