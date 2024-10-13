package auca.ac.rw.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    @Column(nullable = false, name = "semester_name")
    private String semesterName;

    @NonNull
    @Column(nullable = false, name = "start_date")
    private LocalDate startDate;

    @NonNull
    @Column(nullable = false, name = "end_date")
    private LocalDate endDate;

    @OneToMany(mappedBy = "semester", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses;

    @OneToMany(mappedBy = "semester", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentRegistration> studentRegistrations;
}
