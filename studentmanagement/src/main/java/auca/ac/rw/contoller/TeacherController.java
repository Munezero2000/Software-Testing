package auca.ac.rw.contoller;

import org.hibernate.Session;

import auca.ac.rw.model.Teacher;
import auca.ac.rw.util.HibernateUtil;

public class TeacherController {
    @SuppressWarnings("deprecation")
    public String addTeacher(Teacher teacher) {
        try {
            Session session = HibernateUtil.getSession().openSession();
            session.beginTransaction();
            session.save(teacher);
            session.getTransaction().commit();
            session.close();
            return "Teacher saved successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

    }
}
