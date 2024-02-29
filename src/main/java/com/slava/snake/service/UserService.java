package com.slava.snake.service;

import com.slava.snake.collection.User;
import com.slava.snake.dto.AuthDto;
import com.slava.snake.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    
    
    Optional<User> get(String username) {
        return userRepository.findByUsername(username);
    }
    

    User getByUsername(String username) {
        return get(username).orElse(null);
    }


    public User getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }
    
    
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }
        
    
    Optional<User> create(AuthDto auth) {
        Optional<User> user = get(auth.getLogin());
        return user.isEmpty()
                ? Optional.of(userRepository.save(new User(auth)))
                : Optional.empty();
        
    }
    
}
