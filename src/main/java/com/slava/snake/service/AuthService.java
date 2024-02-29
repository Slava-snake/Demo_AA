package com.slava.snake.service;

import com.slava.snake.collection.User;
import com.slava.snake.dto.AuthDto;
import com.slava.snake.dto.JwtAuthResponse;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserService userService;
    
    @Autowired
    JWTtokenService jwtService;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    
    public JwtAuthResponse register(AuthDto auth) {
        Optional<User> user = userService.create(auth);
        return user.isEmpty() ? null : new JwtAuthResponse(jwtService.generateToken(user.get()));
    }
    
    
    public JwtAuthResponse login(AuthDto auth) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(auth.getLogin(), auth.getPassword()));
        UserDetails userdetails = userService.userDetailsService().loadUserByUsername(auth.getLogin());
        return new JwtAuthResponse(jwtService.generateToken(userdetails));
    }
    
}
