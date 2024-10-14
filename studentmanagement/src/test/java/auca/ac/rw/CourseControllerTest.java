package auca.ac.rw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import auca.ac.rw.contoller.AcademicUnitController;
import auca.ac.rw.contoller.CourseController;
import auca.ac.rw.contoller.CourseDefinitionController;
import auca.ac.rw.contoller.SemesterController;
import auca.ac.rw.model.AcademicUnit;
import auca.ac.rw.model.Course;
import auca.ac.rw.model.CourseDefinition;
import auca.ac.rw.model.EAcademicUnit;
import auca.ac.rw.model.Semester;

public class CourseControllerTest {
    @Test
    @DisplayName("Test adding a course")
    public void testAddCourse() {
        AcademicUnit department = new AcademicUnit();
        AcademicUnit academicUnit = new AcademicUnit();
        SemesterController semesterController = new SemesterController();
        CourseController courseController = new CourseController();
        CourseDefinitionController courseDefinitionController = new CourseDefinitionController();
        CourseDefinition courseDefinition = new CourseDefinition();

        // 1. Testing Semester Registration
        Semester semester = new Semester("Spring", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 6, 30));
        Semester returnedSemester = semesterController.addSemester(semester);
        assertNotNull(semester);
        assertEquals(semester.getSemesterName(), returnedSemester.getSemesterName());

        // 2. Testing the Faculty registration
        AcademicUnitController academicUnitController = new AcademicUnitController();
        academicUnit.setAcademicUnitName("Faculty of Information Technology");
        academicUnit.setAcademicUnitType(EAcademicUnit.FACULTY);

        AcademicUnit faculty = academicUnitController.addAcademicUnit(academicUnit);
        assertNotNull(faculty);
        assertEquals(faculty.getAcademicUnitName(), academicUnit.getAcademicUnitName());

        // Ensuring Faculty is saved before saving parent
        if (faculty != null && faculty.getAcademicUnitType() == EAcademicUnit.FACULTY) {

            // 3. Saving Department
            department.setAcademicUnitName("Software Engineering");
            department.setAcademicUnitType(EAcademicUnit.DEPARTMENT);
            department.setParentId(faculty);
            AcademicUnit returnedDepartment = academicUnitController.addAcademicUnit(department);

            Course course = new Course("CS101", "Introduction to Computer Science", 3, semester, returnedDepartment);
            Course returnedCourse = courseController.addCourse(course);
            assertNotNull(returnedCourse);

            // 4. Saving course Definition
            courseDefinition.setDescription("Introduction to Computer Science");
            courseDefinition.setCourse(course);

            CourseDefinition result3 = courseDefinitionController.addCourseDefinition(courseDefinition);
            assertNotNull(result3);
            assertEquals(result3.getCourse(), returnedCourse);
        }
    }
}
