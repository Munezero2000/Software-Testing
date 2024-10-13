package auca.ac.rw.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table; 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_registration")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "semester_id", nullable = false)
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private AcademicUnit department;

    @Column(nullable = false, name = "registration_date")
    private LocalDate registrationDate;

    @Column(nullable = false, name = "registration_number")
    private int registrationNumber;

    @Column(nullable = false, name = "registration_status")
    private String registrationStatus;

    @Override
    public String toString() {
        return "StudentRegistration{" +
                "id=" + student.getStudentId() +
                ", FirstName='" + student.getFirstName() + '\'' +
                ", LastName='" + student.getLastName() + '\'' +
                '}';
    }
}