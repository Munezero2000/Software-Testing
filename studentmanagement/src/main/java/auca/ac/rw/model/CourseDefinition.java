package auca.ac.rw.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "course_definition")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "course_definition_id")
    private UUID id;

    @Column(name = "course_definition_description")
    private String description;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
