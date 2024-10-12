package auca.ac.rw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import auca.ac.rw.contoller.CourseController;
import auca.ac.rw.contoller.CourseDefinitionController;
import auca.ac.rw.model.Course;
import auca.ac.rw.model.CourseDefinition;

public class CourseControllerTest {
    @Test
    @DisplayName("Test adding a course")
    public void testAddCourse() {

        Course course = new Course();
        course.setCourseCode("CS101");
        course.setCourseName("Introduction to Computer Science");
        course.setCourseCreditHours(3);

        CourseController courseController = new CourseController();
        String result = courseController.addCourse(course);
        assertNotNull(result);
        assertEquals("Course saved successfully", result);

        CourseDefinitionController courseDefinitionController = new CourseDefinitionController();
        CourseDefinition courseDefinition = new CourseDefinition();
        courseDefinition.setDescription("Introduction to Computer Science");
        courseDefinition.setCourse(course);

        CourseDefinition result2 = courseDefinitionController.addCourseDefinition(courseDefinition);
        assertNotNull(result2);
    }
}
