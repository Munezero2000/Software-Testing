package auca.ac.rw;

import static org.junit.jupiter.api.Assertions.assertEquals;

import auca.ac.rw.contoller.TeacherController;
import auca.ac.rw.model.EQualification;
import auca.ac.rw.model.Teacher;

public class TeacherControllerTest {
    public void testAddTeacher() {
        TeacherController teacherCont = new TeacherController();
        Teacher teacher = new Teacher();
        teacher.setFirstName("Munezero");
        teacher.setLastName("Ange");
        teacher.setQualification(EQualification.PROFESSOR);
        assertEquals("Teacher saved successfully", teacherCont.addTeacher(teacher));
    }
}
