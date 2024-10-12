package auca.ac.rw;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import auca.ac.rw.contoller.StudentController;
import auca.ac.rw.model.Student;

public class StudentControllerTest {

    @Test
    public static Student testAddStudent() {
        StudentController studentController = new StudentController();
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setDateOfBirth(LocalDate.of(1990, 1, 1));
        Student result = studentController.addStudent(student);
        assertEquals(result.getFirstName(), student.getFirstName());
        return result;
    }

}
