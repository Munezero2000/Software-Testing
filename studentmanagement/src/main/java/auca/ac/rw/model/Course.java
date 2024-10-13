package auca.ac.rw.model;

import java.util.*;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "course")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    @Column(name = "course_code")
    private String courseCode;

    @NonNull
    @Column(name = "course_name")
    private String courseName;

    @NonNull
    @Column(name = "course_credit_hours")
    private Integer courseCreditHours;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "department_id")
    private AcademicUnit department;

    @OneToOne(mappedBy = "course")
    private CourseDefinition courseDefinition;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    private List<Teacher> teachers;
}
