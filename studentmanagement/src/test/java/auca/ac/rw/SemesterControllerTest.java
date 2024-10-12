package auca.ac.rw;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import auca.ac.rw.contoller.SemesterController;
import auca.ac.rw.model.Semester;

public class SemesterControllerTest {

    @Test
    @DisplayName("Test adding a semester")
    public static void testAddSemester() {
        Semester semester = new Semester("First Semester", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 6, 30));
        SemesterController semesterController = new SemesterController();
        Semester result = semesterController.addSemester(semester);
        assertNotNull(result);
    }
}
