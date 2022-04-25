package com.lab2.demo.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    librarian;

    @Override
    public String getAuthority() {
        return null;
    }
}
