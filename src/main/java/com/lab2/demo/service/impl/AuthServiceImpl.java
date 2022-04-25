package com.lab2.demo.service.impl;

import com.lab2.demo.exceptions.InvalidArgumentsException;
import com.lab2.demo.exceptions.InvalidUserCredentialsException;
import com.lab2.demo.model.User;
import com.lab2.demo.repository.UserRepository;
import com.lab2.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }

}
