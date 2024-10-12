package auca.ac.rw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import auca.ac.rw.contoller.AcademicUnitController;
import auca.ac.rw.contoller.CourseController;
import auca.ac.rw.contoller.CourseDefinitionController;
import auca.ac.rw.model.AcademicUnit;
import auca.ac.rw.model.Course;
import auca.ac.rw.model.CourseDefinition;
import auca.ac.rw.model.EAcademicUnit;
import auca.ac.rw.model.Semester;

public class CourseControllerTest {
    @Test
    @DisplayName("Test adding a course")
    public void testAddCourse() {
        Semester semester = new Semester("Spring", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 6, 30));
        AcademicUnitController academicUnitController = new AcademicUnitController();
        AcademicUnit academicUnit = new AcademicUnit();
        academicUnit.setAcademicUnitName("Faculty of Information Technology");
        academicUnit.setAcademicUnitType(EAcademicUnit.FACULTY);

        AcademicUnit result = academicUnitController.addAcademicUnit(academicUnit);
        System.out.println(result);

        // Testing the Faculty registration
        assertNotNull(result);
        assertEquals(result.getAcademicUnitName(), academicUnit.getAcademicUnitName());

        if (result != null && result.getAcademicUnitType() == EAcademicUnit.FACULTY) {
            AcademicUnit department = new AcademicUnit();
            department.setAcademicUnitName("Software Engineering");
            department.setAcademicUnitType(EAcademicUnit.DEPARTMENT);
            department.setParentId(result);
            AcademicUnit returnedDepartment = academicUnitController.addAcademicUnit(department);
            Course course = new Course("CS101", "Introduction to Computer Science", 3, semester, returnedDepartment);
            course.setSemester(semester);
            CourseController courseController = new CourseController();
            Course result2 = courseController.addCourse(course);
            assertNotNull(result);
            assertEquals("Course saved successfully", result);

            CourseDefinitionController courseDefinitionController = new CourseDefinitionController();
            CourseDefinition courseDefinition = new CourseDefinition();
            courseDefinition.setDescription("Introduction to Computer Science");
            courseDefinition.setCourse(course);

            CourseDefinition result3 = courseDefinitionController.addCourseDefinition(courseDefinition);
            assertNotNull(result3);
            assertEquals("Course definition saved successfully", result3);
            assertEquals(result3.getCourse(), course);
        }
    }
}
