package com.example.StudentNotificationSystem.Controllers;

import com.example.StudentNotificationSystem.models.User;
import com.example.StudentNotificationSystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user) {
        userService.creatUser(user);
        return "redirect:/login";
    }

    @GetMapping("/subjects")
    public String subjects(Principal principal) {
        userService.subjects(principal);
        return "registration";
    }
}
