package auca.ac.rw.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, name = "semester_name")
    private String semesterName;

    @Column(nullable = false, name = "start_date")
    private String startData;

    @Column(nullable = false, name = "end_date")
    private String end_date;

}