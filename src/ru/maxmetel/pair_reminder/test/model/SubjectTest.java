package ru.maxmetel.pair_reminder.test.model;

import org.junit.Before;
import org.junit.Test;
import ru.maxmetel.pair_reminder.main.model.Subject;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

public class SubjectTest {
    private Subject subject;

    @Before
    public void setUp() {
        try {
			subject = new Subject("18.10.2016", "17:00", "20:30", "a", "b", "c", "d");
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }

    @Test
    public void setStartTime() throws Exception {
        subject.setStartTime("18.10.2016", "17:00");
        assertEquals("Tue Oct 18 17:00:00 NOVT 2016", subject.getStartTime().toString());
    }

    @Test
    public void setEndTime() throws Exception {
        subject.setEndTime("20.10.2016", "18:00");
        assertEquals("Thu Oct 20 18:00:00 NOVT 2016", subject.getEndTime().toString());
    }
}