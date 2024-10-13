package auca.ac.rw.contoller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public Semester getSemesterById(UUID semesterId) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            Semester semester = session.get(Semester.class, semesterId);
            return semester;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<StudentRegistration> getSemeterStudentRegistrations(UUID semesterId) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            Semester semester = session.get(Semester.class, semesterId);
            System.out.println("Student Registrations: ");
            Map<UUID, StudentRegistration> uniqueRegistrationsMap = new HashMap<>();
            for (StudentRegistration registration : semester.getStudentRegistrations()) {
                uniqueRegistrationsMap.put(registration.getStudent().getStudentId(), registration);
                System.out.println("Student Name: " + registration.getStudent().getFirstName() + " "
                        + registration.getStudent().getLastName());
            }
            List<StudentRegistration> uniqueRegistrations = new ArrayList<>(uniqueRegistrationsMap.values());
            return uniqueRegistrations;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
