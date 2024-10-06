package auca.ac.rw.model;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "course_name")
    private String courseName;

    @OneToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @OneToOne
    @JoinColumn(name = "department_id")
    private AcademicUnit department;

    @OneToOne(mappedBy = "course")
    private CourseDefinition courseDefinition;

    @OneToOne(mappedBy = "course")
    private Teacher teacher;

}
