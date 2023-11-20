package com.lab5_1.models;

import com.lab5_1.hibernate.HibernateUtils;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserServise {
    private static SessionFactory sessionFactory;
    public void UserServise(){
        sessionFactory = HibernateUtils.getSessionFactory();
    }
    public static List<User> getUserList(){
        Session session = HibernateUtils.startSession();
        session.get(User.class, 1L);

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);


        Query query = session.createQuery(cq);
        List<User> userList = query.getResultList();

        session.close();


        return userList;
    }

}
