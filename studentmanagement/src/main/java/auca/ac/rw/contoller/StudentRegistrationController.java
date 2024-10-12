package auca.ac.rw.contoller;

import org.hibernate.Session;

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
}
