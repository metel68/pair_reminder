package pair_reminder.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SubjectsList {

    @SerializedName("subjects")
    @Expose
    private java.util.List<Subject> subjects = new ArrayList<Subject>();

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

}