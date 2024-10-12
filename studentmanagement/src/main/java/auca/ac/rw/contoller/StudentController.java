package auca.ac.rw.contoller;

import java.time.LocalDate;

import org.hibernate.Session;

import auca.ac.rw.model.Student;
import auca.ac.rw.util.HibernateUtil;

public class StudentController {
    public String addStudent() {
        Student student = new Student();
        student.setFirstName("John");
        student.setDateOfBirth(LocalDate.of(1990, 1, 1));
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
        session.close();
        return "Student added successfully";
    }
}
