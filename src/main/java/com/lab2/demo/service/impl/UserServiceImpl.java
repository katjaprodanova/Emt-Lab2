package com.lab2.demo.service.impl;

import com.lab2.demo.exceptions.InvalidUserCredentialsException;
import com.lab2.demo.model.Role;
import com.lab2.demo.model.User;
import com.lab2.demo.repository.UserRepository;
import com.lab2.demo.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws InvalidUserCredentialsException {
        return userRepository.findByUsername(s).orElseThrow(()->new InvalidUserCredentialsException());
    }


    @Override
    public User register(String username, String password, String repeatPassword, Role userRole) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUserCredentialsException();
        if (!password.equals(repeatPassword))
            throw new InvalidUserCredentialsException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new InvalidUserCredentialsException();
        User user = new User(username,passwordEncoder.encode(password),userRole);
        return userRepository.save(user);
    }
}
