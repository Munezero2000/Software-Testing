package auca.ac.rw;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import auca.ac.rw.contoller.SemesterController;
import auca.ac.rw.model.Semester;
import auca.ac.rw.model.StudentRegistration;

public class SemesterControllerTest {

    @Test
    @DisplayName("Test adding a semester")
    public void testAddSemester() {
        Semester semester = new Semester("First Semester", LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 6, 30));
        SemesterController semesterController = new SemesterController();
        Semester result = semesterController.addSemester(semester);
        assertNotNull(result);
    }

    @Test
    @DisplayName("Test getting a semester by id")
    public void testGetSemesterById() {
        SemesterController semesterController = new SemesterController();
        Semester semester = semesterController.getSemesterById(UUID.fromString("24964a65-f492-4b93-98fb-4d41f23a7db0"));
        assertNotNull(semester);
    }

    @Test
    @DisplayName("Test getting unique student registrations")
    public void testGetUniqueStudentRegistrations() {
        SemesterController semesterController = new SemesterController();
        List<StudentRegistration> uniqueStudentRegistrations = semesterController
                .getSemeterStudentRegistrations(UUID.fromString("24964a65-f492-4b93-98fb-4d41f23a7db0"));
        System.out.println(uniqueStudentRegistrations);
        assertNotNull(uniqueStudentRegistrations);
    }
}