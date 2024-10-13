package auca.ac.rw.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "academic_unit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicUnit {

    @Id
    @Column(name = "academic_unit_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID academicUnitId;

    @Column(name = "academic_unit_name")
    private String academicUnitName;

    @Column(name = "academic_unit_type")
    @Enumerated(EnumType.STRING)
    private EAcademicUnit academicUnitType;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private AcademicUnit parentId; // This is the parent academic unit, self reference

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private List<StudentRegistration> studentRegistrations;
}