package auca.ac.rw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import auca.ac.rw.contoller.AcademicUnitController;
import auca.ac.rw.contoller.CourseController;
import auca.ac.rw.contoller.CourseDefinitionController;
import auca.ac.rw.contoller.SemesterController;
import auca.ac.rw.contoller.StudentRegistrationController;
import auca.ac.rw.model.AcademicUnit;
import auca.ac.rw.model.Course;
import auca.ac.rw.model.CourseDefinition;
import auca.ac.rw.model.EAcademicUnit;
import auca.ac.rw.model.Semester;
import auca.ac.rw.model.StudentRegistration;

public class StudentRegistrationControllerTest {

    @Test
    @DisplayName("Test registering a student")
    public void testRegisterStudent() {
        // Create an instance of the StudentRegistrationController
        StudentRegistrationController studentRegistrationController = new StudentRegistrationController();

        // Create a new StudentRegistration object
        StudentRegistration studentRegistration = new StudentRegistration();

        // Create a new Semester object for the Spring semester
        Semester semester = new Semester("Spring", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 6, 30));
        SemesterController semesterController = new SemesterController();

        // Add the semester to the database and retrieve the saved semester
        Semester savedSemester = semesterController.addSemester(semester);

        // Create an instance of the AcademicUnitController
        AcademicUnitController academicUnitController = new AcademicUnitController();

        // Create and populate a new AcademicUnit for the Faculty
        AcademicUnit academicUnit = new AcademicUnit();
        academicUnit.setAcademicUnitName("Faculty of Information Technology");
        academicUnit.setAcademicUnitType(EAcademicUnit.FACULTY);

        // Add the academic unit to the database and retrieve the result
        AcademicUnit result = academicUnitController.addAcademicUnit(academicUnit);
        System.out.println(result);

        // Assert that the academic unit was created successfully
        assertNotNull(result);
        assertEquals(result.getAcademicUnitName(), academicUnit.getAcademicUnitName());

        // Check if the result is a faculty unit
        if (result != null && result.getAcademicUnitType() == EAcademicUnit.FACULTY) {
            // Create and populate a new AcademicUnit for the Software Engineering
            // department
            AcademicUnit department = new AcademicUnit();
            department.setAcademicUnitName("Software Engineering");
            department.setAcademicUnitType(EAcademicUnit.DEPARTMENT);
            department.setParentId(result); // Set the parent to the Faculty

            // Add the department to the database
            AcademicUnit returnedDepartment = academicUnitController.addAcademicUnit(department);

            // Create and populate a new Course
            Course course = new Course("CS101", "Introduction to Computer Science", 3, savedSemester,
                    returnedDepartment);
            course.setSemester(semester);

            // Create an instance of the CourseController
            CourseController courseController = new CourseController();

            // Add the course to the database and retrieve the result
            Course result2 = courseController.addCourse(course);
            assertNotNull(result2);
            assertEquals(result2, course); // Ensure the course was added correctly

            // Create and populate a new CourseDefinition
            CourseDefinitionController courseDefinitionController = new CourseDefinitionController();
            CourseDefinition courseDefinition = new CourseDefinition();
            courseDefinition.setDescription("Introduction to Computer Science");
            courseDefinition.setCourse(course);

            // Add the course definition to the database
            CourseDefinition result3 = courseDefinitionController.addCourseDefinition(courseDefinition);
            assertNotNull(result3); // Ensure the course definition was added successfully

            // Populate the StudentRegistration object with data
            studentRegistration.setCourse(result2);
            studentRegistration.setSemester(semester);
            studentRegistration.setRegistrationDate(LocalDate.now());
            studentRegistration.setStudent(StudentControllerTest.testAddStudent());

            // Register the student
            studentRegistrationController.registerStudent(studentRegistration);
        }
    }
}
