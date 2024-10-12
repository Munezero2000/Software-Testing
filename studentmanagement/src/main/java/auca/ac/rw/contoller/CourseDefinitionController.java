package auca.ac.rw.contoller;

import org.hibernate.Session;

import auca.ac.rw.model.CourseDefinition;
import auca.ac.rw.util.HibernateUtil;

public class CourseDefinitionController {
    public CourseDefinition addCourseDefinition(CourseDefinition courseDefinition) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            session.beginTransaction();
            session.persist(courseDefinition);
            session.getTransaction().commit();
            return courseDefinition;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
