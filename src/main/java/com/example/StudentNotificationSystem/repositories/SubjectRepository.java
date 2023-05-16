package com.example.StudentNotificationSystem.repositories;

import com.example.StudentNotificationSystem.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> { // наследуем все методы (получить, удалить, ...)
    List<Subject> findByTitle(String title);
}
