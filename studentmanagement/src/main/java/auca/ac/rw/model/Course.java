package auca.ac.rw.model;

import java.util.*;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_credit_hours")
    private Integer courseCreditHours;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private AcademicUnit department;

    @OneToOne(mappedBy = "course")
    private CourseDefinition courseDefinition;

    @ManyToMany(mappedBy = "courses")
    private List<Teacher> teachers;

}
