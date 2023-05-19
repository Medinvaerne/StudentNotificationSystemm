package com.example.StudentNotificationSystem.services;

import com.example.StudentNotificationSystem.models.Subject;
import com.example.StudentNotificationSystem.models.User;
import com.example.StudentNotificationSystem.repositories.SubjectRepository;
import com.example.StudentNotificationSystem.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;
    public List<Subject> listSubjects(String title) // передаем все предметы
    {
        if (title != null) return subjectRepository.findByTitle(title);
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Long id) {
            return subjectRepository.findById(id).orElse(null);
    }
    public void saveSubject(User user, Subject subject)
    {
        subject.setUser(user);
        subjectRepository.save(subject);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public void deleteSubject (Long id)
    {
        subjectRepository.deleteById(id);
    }


    public List<Subject> lectorSubjectList(String name) {
        return subjectRepository.findByLecturer(name);
    }
}
