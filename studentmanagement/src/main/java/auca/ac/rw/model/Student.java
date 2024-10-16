package auca.ac.rw.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "student")
    private List<StudentRegistration> studentRegistrations;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + studentId +
                ", name='" + firstName + " " + lastName + '\'' +
                // Avoid including student registrations directly
                '}';
    }
}
