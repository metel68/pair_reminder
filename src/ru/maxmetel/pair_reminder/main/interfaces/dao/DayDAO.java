package ru.maxmetel.pair_reminder.main.interfaces.dao;

import ru.maxmetel.pair_reminder.main.model.Day;

import java.util.List;

public interface DayDAO {

    public Day insert(Day day);

    public void update(Day day);

    public void save(Day day);

    public Day getById(int id);

    public List<Day> getAll();
}
