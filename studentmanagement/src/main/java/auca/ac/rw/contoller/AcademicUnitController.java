package auca.ac.rw.contoller;

import org.hibernate.Session;

import auca.ac.rw.model.AcademicUnit;
import auca.ac.rw.util.HibernateUtil;

public class AcademicUnitController {
    public AcademicUnit addAcademicUnit(AcademicUnit academicUnit) {
        try {
            Session session = HibernateUtil.getSession().openSession();
            session.beginTransaction();
            session.persist(academicUnit);
            session.getTransaction().commit();
            session.close();
            return academicUnit;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
