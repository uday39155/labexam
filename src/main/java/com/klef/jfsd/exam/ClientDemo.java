package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        // Load Hibernate configuration and build SessionFactory
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // Open a session
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            // Begin transaction
            transaction = session.beginTransaction();

            // Update operation using HQL with positional parameters
            String hql = "UPDATE Department SET name = ?1, location = ?2 WHERE departmentId = ?3";
            int updatedEntities = session.createQuery(hql)
                    .setParameter(1, "Updated Department Name")
                    .setParameter(2, "Updated Location")
                    .setParameter(3, 1) // Assume Department ID is 1 for this example
                    .executeUpdate();

            // Commit transaction
            transaction.commit();

            System.out.println("Records updated: " + updatedEntities);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close session
            session.close();
            sessionFactory.close();
        }
    }
}
