package ru.maxmetel.pair_reminder.main.daoimpl;

import org.hibernate.Session;

public class BaseDAOImpl {

    protected Session getSession() {
        return HibernateUtils.getSessionFactory().openSession();
    }
}
