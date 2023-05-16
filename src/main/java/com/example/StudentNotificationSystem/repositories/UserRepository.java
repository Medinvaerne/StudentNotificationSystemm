package com.example.StudentNotificationSystem.repositories;

import com.example.StudentNotificationSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long > {
    User findByEmail(String email);

}
