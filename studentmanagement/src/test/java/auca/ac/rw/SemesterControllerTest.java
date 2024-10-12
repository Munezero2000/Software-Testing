package auca.ac.rw;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import auca.ac.rw.model.Semester;

public class SemesterControllerTest {

    @Test
    @DisplayName("Test adding a semester")
    public void testAddSemester() {
        Semester semester = new Semester();
        semester.setSemesterName("First Semester");
        semester.setStartData(LocalDate.of(2024, 1, 1));
        semester.setEnd_date(LocalDate.of(2024, 6, 30));
    }
}
