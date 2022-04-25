package com.lab2.demo.service;

import com.lab2.demo.model.User;

public interface AuthService {
    User login(String username, String password);
}
