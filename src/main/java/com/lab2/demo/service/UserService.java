package com.lab2.demo.service;

import com.lab2.demo.model.Role;
import com.lab2.demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, Role role);
}
