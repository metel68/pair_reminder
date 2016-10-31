package ru.maxmetel.pair_reminder.main.daoimpl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.maxmetel.pair_reminder.main.model.Day;
import ru.maxmetel.pair_reminder.main.model.Subject;

public class HibernateUtils {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        try {
            Configuration conf = new Configuration();
            conf.addAnnotatedClass(Subject.class);
            conf.addAnnotatedClass(Day.class);
            return conf.configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}