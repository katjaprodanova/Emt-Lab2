package com.lab2.demo.service;

import com.lab2.demo.model.Author;

import java.util.Optional;

public interface AuthorService {
    Optional<Author> findbyName();
}
