package com.example.StudentNotificationSystem.models;

import com.example.StudentNotificationSystem.models.enums.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Email
    @Column(name = "email", unique = true)
    private String email;
    @NotBlank
    @Size(min = 2, max = 100, message = "имя должно находиться в диапазоне от 1 до 50 символов")
    @Column(name = "name")
    private String name;
    @Column(name = "active")
    private boolean active;
    @Column(name = "password", length = 1000)
    private String Password;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private List<Subject> subjects = new ArrayList<>();

    public boolean isAdmin() {
        return roles.contains(Role.ROLE_ADMIN);
    }
    public boolean isTeacher() { return roles.contains(Role.ROLE_TEACHER); }
    public boolean isStudent() { return roles.contains(Role.ROLE_STUDENT); }

    public boolean isLecturer() { return roles.contains(Role.ROLE_LECTURER); }

    /*@ManyToMany(mappedBy = "student",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Subject> subjects1;*/

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

}
