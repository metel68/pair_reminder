package ru.maxmetel.pair_reminder.main.daoimpl;


import org.hibernate.Session;
import ru.maxmetel.pair_reminder.main.interfaces.dao.DayDAO;
import ru.maxmetel.pair_reminder.main.model.Day;

import java.util.List;

public class DayDAOImpl extends BaseDAOImpl implements DayDAO{

    @Override
    public Day insert(Day day) {
        try (Session session = getSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(day);
            day.setId(id);
            session.getTransaction().commit();
            return day;
        }
    }

    @Override
    public void update(Day day) {
        try (Session session = getSession()) {
            session.beginTransaction();
            session.update(day);
            session.getTransaction().commit();
        }
    }

    @Override
    public void save(Day day) {
        if(getById(day.getId()) == null) {
            insert(day);
        } else {
            update(day);
        }
    }

    @Override
    public Day getById(int id) {
        try (Session session = getSession()) {
            return session.get(Day.class, id);
        }
    }

    @Override
    public List<Day> getAll() {
        try (Session session = getSession()) {
            return session.createQuery("from Day").list();
        }
    }
}
