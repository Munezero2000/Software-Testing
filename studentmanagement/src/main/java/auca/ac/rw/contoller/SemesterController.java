package auca.ac.rw.contoller;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;

import auca.ac.rw.model.Semester;
import auca.ac.rw.model.StudentRegistration;
import auca.ac.rw.util.HibernateUtil;

public class SemesterController {
    public Semester addSemester(Semester semester) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            session.beginTransaction();
            session.persist(semester);
            session.getTransaction().commit();
            session.close();
            return semester;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<StudentRegistration> getSemesterStudents(UUID semesterId) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            Semester semester = session.get(Semester.class, semesterId);
            return semester.getStudentRegistrations();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
