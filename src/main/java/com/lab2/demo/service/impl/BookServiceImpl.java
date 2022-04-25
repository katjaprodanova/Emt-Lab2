package com.lab2.demo.service.impl;

import com.lab2.demo.repository.BookRepository;
import com.lab2.demo.repository.UserRepository;
import com.lab2.demo.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookServiceImpl(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }
}
