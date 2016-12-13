package pair_reminder.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SubjectsList {

    @SerializedName("subjects")
    @Expose
    private java.util.List<Subject> subjects = new ArrayList<Subject>();

    @SerializedName("date")
    @Expose
    private String date;

    /**
     * @return The subjects
     */
    public java.util.List<Subject> getSubjects() {
        return subjects;
    }

    /**
     * @param subjects The subjects
     */
    public void setSubjects(java.util.List<Subject> subjects) {
        this.subjects = subjects;
    }

    /**
     * @return The date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date The date
     */
    public void setDate(String date) {
        this.date = date;
    }

}