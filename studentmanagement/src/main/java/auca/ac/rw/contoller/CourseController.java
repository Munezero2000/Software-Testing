package auca.ac.rw.contoller;

import org.hibernate.Session;

import auca.ac.rw.model.Course;
import auca.ac.rw.util.HibernateUtil;

public class CourseController {
    public String addCourse(Course course) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            session.beginTransaction();
            session.persist(course);
            session.getTransaction().commit();
            return "Course saved successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error adding course";
        }
    }
}
