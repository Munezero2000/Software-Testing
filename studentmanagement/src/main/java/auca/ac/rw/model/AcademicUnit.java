package auca.ac.rw.model;

import jakarta.persistence.*;

@Entity
@Table(name = "academic_unit")
public class AcademicUnit {

    @Id
    @Column(name = "academic_unit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long academicUnitId;

    @Column(name = "academic_unit_name")
    private String academicUnitName;

    @Column(name = "academic_unit_type")
    @Enumerated(EnumType.STRING)
    private EAcademicUnit academicUnitType;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private AcademicUnit parentId;
}
