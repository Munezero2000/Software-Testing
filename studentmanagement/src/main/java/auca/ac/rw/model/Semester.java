package auca.ac.rw.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Semester {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, name = "semester_name")
    private String semesterName;

    @Column(nullable = false, name = "start_date")
    private String startData;

    @Column(nullable = false, name = "end_date")
    private String end_date;

}