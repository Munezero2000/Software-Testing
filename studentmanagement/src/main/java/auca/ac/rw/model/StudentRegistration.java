package auca.ac.rw.model;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
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

    @ManyToMany
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_registration_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;

    @ManyToOne
    @JoinColumn(name = "semester_id", nullable = false)
    private Semester semester;

    @Column(nullable = false, name = "registration_date")
    private String registrationData;

    @Column(nullable = false, name = "registration_number")
    private int registrationNumber;

    @Column(nullable = false, name = "registration_status")
    private String registrationStatus;
}