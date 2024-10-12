package auca.ac.rw.contoller;

import java.time.LocalDate;

import org.hibernate.Session;

import auca.ac.rw.model.Student;
import auca.ac.rw.util.HibernateUtil;

public class StudentController {
    public Student addStudent(Student student) {
        try (Session session = HibernateUtil.getSession().openSession()) {

            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
            session.close();
            return student;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
