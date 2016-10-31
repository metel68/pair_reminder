package ru.maxmetel.pair_reminder.main.interfaces.dao;


import ru.maxmetel.pair_reminder.main.model.Subject;

import java.util.Date;
import java.util.List;

public interface SubjectDAO {

    public Subject insert(Subject subject);

    public void update(Subject subject);

    public void save(Subject subject);

    public Subject getById(int id);

    public List<Subject> getAll();

    public List<Subject> getByDateRange(Date from, Date to);
}
