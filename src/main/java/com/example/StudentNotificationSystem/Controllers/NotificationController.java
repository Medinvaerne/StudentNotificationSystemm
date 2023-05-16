package com.example.StudentNotificationSystem.Controllers;

import com.example.StudentNotificationSystem.models.Subject;
import com.example.StudentNotificationSystem.models.User;
import com.example.StudentNotificationSystem.repositories.UserRepository;
import com.example.StudentNotificationSystem.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.loading.PrivateClassLoader;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class NotificationController {
    private final SubjectService subjectService;
    private final UserRepository userRepository;


    @GetMapping("/") // Начальная страница сайта
    public String notifications(@RequestParam(name = "title", required = false) String title, Principal principal,  Model model ){

        model.addAttribute("subjects", subjectService.listSubjects(title));
        User userByPrincipal = subjectService.getUserByPrincipal(principal);
        if (userByPrincipal.isStudent()){
            model.addAttribute("retakes", userByPrincipal.getSubjects());
        }
        model.addAttribute("user", subjectService.getUserByPrincipal(principal));

        return "notifications";
    }

    @GetMapping("/subject/{id}")
    public String subjectInfo(@PathVariable Long id, Model model)
    {

        model.addAttribute("subject", subjectService.getSubjectById(id));

        return "subject-info";
    }



    @PostMapping("/subject/create")
    public String createSubject(@RequestParam(name = "email") String email,Subject subject, Principal principal) {
        User user = userRepository.findByEmail(email);

        subjectService.saveSubject(user, subject);
        return "redirect:/";
    }

    @PostMapping("/subject/delete/{id}")
    public String deleteSubject(@PathVariable long id) {
        subjectService.deleteSubject(id);
        return "redirect:/";
    }
}
