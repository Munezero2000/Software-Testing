package auca.ac.rw;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import auca.ac.rw.contoller.StudentController;

public class StudentControllerTest {
    @Test
    public void testAddStudent() {
        StudentController studentController = new StudentController();
        String result = studentController.addStudent();
        assertEquals("Student added successfully", result);
    }

}
