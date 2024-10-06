package auca.ac.rw.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, name = "department_code")
    private String departmentCode;

    @Column(nullable = false, name = "department_name")
    private String departmentName;

}