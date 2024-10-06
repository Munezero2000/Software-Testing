package auca.ac.rw.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teachers")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "teacher_id")
    private UUID Id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "qualification")
    @Enumerated(EnumType.STRING)
    private EQualification qualification;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
