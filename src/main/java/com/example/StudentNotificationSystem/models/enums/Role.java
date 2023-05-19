package com.example.StudentNotificationSystem.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_STUDENT, ROLE_TEACHER, ROLE_LECTURER, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
