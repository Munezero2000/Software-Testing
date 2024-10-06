package auca.ac.rw.util;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import auca.ac.rw.model.AcademicUnit;
import auca.ac.rw.model.Course;
import auca.ac.rw.model.CourseDefinition;
import auca.ac.rw.model.Department;
import auca.ac.rw.model.Semester;
import auca.ac.rw.model.Student;
import auca.ac.rw.model.StudentRegistration;
import auca.ac.rw.model.Teacher;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    @SuppressWarnings("deprecation")
    public static SessionFactory getSession() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            Properties property = new Properties();
            property.put(Environment.DRIVER, "org.postgresql.Driver");
            property.put(Environment.URL, "jdbc:postgresql://localhost:5432/testing");
            property.put(Environment.USER, "postgres");
            property.put(Environment.PASS, "Munezero25");
            property.put(Environment.SHOW_SQL, true);
            property.put(Environment.HBM2DDL_AUTO, "update");

            configuration.addProperties(property);

            configuration.addAnnotatedClass(Teacher.class);
            configuration.addAnnotatedClass(Course.class);
            configuration.addAnnotatedClass(StudentRegistration.class);
            configuration.addAnnotatedClass(Student.class);
            configuration.addAnnotatedClass(Department.class);
            configuration.addAnnotatedClass(Semester.class);
            configuration.addAnnotatedClass(AcademicUnit.class);
            configuration.addAnnotatedClass(CourseDefinition.class);
            sessionFactory = configuration.buildSessionFactory();
            return sessionFactory;
        } else {
            return sessionFactory;
        }

    }
}
