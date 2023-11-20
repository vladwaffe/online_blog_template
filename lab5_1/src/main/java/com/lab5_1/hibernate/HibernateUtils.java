package com.lab5_1.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
public class HibernateUtils {

    private static SessionFactory sessionFactory;
    private static Session session;

    static{
        // Loads hibernate.cfg.xml by default
        Configuration
            cfg = null;
        try {
            cfg = new Configuration().configure();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }


        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        ServiceRegistry service=ssrb.build();

            sessionFactory = cfg.buildSessionFactory(service);

    }

    /**
     * Get session
     */

    public static Session startSession(){
        return sessionFactory.openSession();
    }
    public static Session getSession() throws HibernateException {
        // We could also use openSession()
        return sessionFactory.getCurrentSession();
    }

    /**
     * Close session
     */
    public static void closeSession() throws HibernateException {
        if(session != null && session.isOpen()){
            session.close();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void closeSession(Session session) throws HibernateException {
        if(session!=null&&session.isOpen()){
            session.close();
        }
    }
}