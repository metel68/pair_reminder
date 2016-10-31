package ru.maxmetel.pair_reminder.main.model;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "days")
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(cascade =  CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Subject> subjects;

    public Day(List<Subject> subjects) {
        this(0, subjects);
    }

    public Day(int id, List<Subject> subjects) {
        this.id = id;
        this.subjects = subjects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
