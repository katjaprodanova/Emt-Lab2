package com.lab2.demo.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookDto {

    private LocalDateTime valid;

    public BookDto() {
    }

    public BookDto(LocalDateTime valid) {
        this.valid = valid;
    }
}
