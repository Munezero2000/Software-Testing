package auca.ac.rw.contoller;

import java.util.List;
import java.util.UUID;

import auca.ac.rw.model.Semester;
import auca.ac.rw.model.StudentRegistration;

public class ReportController {
    public List<StudentRegistration> getSemesterStudent(UUID semesterId) {
        System.out.println("Getting semester student report");
        SemesterController sem = new SemesterController();
        Semester semester = sem.getSemesterById(semesterId);
        semester.getStudentRegistrations();
        System.out.println(semester.getStudentRegistrations());
        for (StudentRegistration registration : semester.getStudentRegistrations()) {
            System.out.println("Student Name: " + registration.getStudent().getFirstName() + " "
                    + registration.getStudent().getLastName());
        }
        return semester.getStudentRegistrations();
    }
}
