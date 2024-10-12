package auca.ac.rw.contoller;

import org.hibernate.Session;

import auca.ac.rw.model.Semester;
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
}
