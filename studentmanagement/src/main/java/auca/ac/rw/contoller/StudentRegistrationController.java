package auca.ac.rw.contoller;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.query.Query;

import auca.ac.rw.model.StudentRegistration;
import auca.ac.rw.util.HibernateUtil;

public class StudentRegistrationController {
    public String registerStudent(StudentRegistration studentRegistration) {
        try {
            Session session = HibernateUtil.getSession().openSession();
            session.beginTransaction();
            session.persist(studentRegistration);
            session.getTransaction().commit();
            return "Student registered successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error registering student";
        }
    }

    // public List<StudentRegistration> getStudentRegistrationsBySemesterId(UUID
    // semesterId) {
    // try (Session session = HibernateUtil.getSession().openSession()) {
    // return session.createQuery("FROM StudentRegistration WHERE semester_id =
    // :semesterId", StudentRegistration.class)
    // } catch (Exception e) {
    // e.printStackTrace();
    // return null;
    // }
    // }
}
