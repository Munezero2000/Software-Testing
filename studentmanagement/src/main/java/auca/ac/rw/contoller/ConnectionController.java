package auca.ac.rw.contoller;

import org.hibernate.Session;

import auca.ac.rw.util.HibernateUtil;

public class ConnectionController {
    HibernateUtil connection = new HibernateUtil();

    public String establishConnection() {
        try (Session session = HibernateUtil.getSession().openSession()) {
            return "Connection Established";
        } catch (Exception ex) {
            System.out.println("I am here Error: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
