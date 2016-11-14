package pair_reminder.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Subject {

    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("subjectName")
    @Expose
    private String subjectName;
    @SerializedName("teacher")
    @Expose
    private String teacher;
    @SerializedName("room")
    @Expose
    private String room;
    @SerializedName("group")
    @Expose
    private String group;

    /**
     * @return The startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime The startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return The endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime The endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @return The subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName The subjectName
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * @return The teacher
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * @param teacher The teacher
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    /**
     * @return The room
     */
    public String getRoom() {
        return room;
    }

    /**
     * @param room The room
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * @return The group
     */
    public String getGroup() {
        return group;
    }

    /**
     * @param group The group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    public String getDate() {
        final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(new Date(getStartTime()));
    }

    @Override
    public String toString() {
        return String.format("%s-%s, \n%s, \n%s, \n%s, \n%s\n\n",
                startTime, endTime, subjectName, teacher, room, group);
    }
}