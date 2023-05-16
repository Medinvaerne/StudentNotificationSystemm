package com.example.StudentNotificationSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subjects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "lecturer")
    private String lecturer;
    @Column(name = "auditorium")
    private String auditorium;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;

    /*@ManyToMany
    @JoinTable(name = "subject_student",
            joinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private List <User> student;*/

    @ManyToOne
    @JoinColumn
    private User user;
}
