package auca.ac.rw.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course_definition")
public class CourseDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_definition_id")
    private Long Id;

    @Column(name = "course_definition_description")
    private String description;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
