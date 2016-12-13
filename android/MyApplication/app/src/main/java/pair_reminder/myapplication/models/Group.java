package pair_reminder.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Group {

    @SerializedName("chairOid")
    @Expose
    private Integer chairOid;
    @SerializedName("course")
    @Expose
    private String course;
    @SerializedName("faculty")
    @Expose
    private String faculty;
    @SerializedName("facultyOid")
    @Expose
    private Integer facultyOid;
    @SerializedName("formOfEducation")
    @Expose
    private String formOfEducation;
    @SerializedName("groupOid")
    @Expose
    private Integer groupOid;
    @SerializedName("kindOfEducation")
    @Expose
    private Integer kindOfEducation;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("speciality")
    @Expose
    private String speciality;

    /**
     * @return The chairOid
     */
    public Integer getChairOid() {
        return chairOid;
    }

    /**
     * @param chairOid The chairOid
     */
    public void setChairOid(Integer chairOid) {
        this.chairOid = chairOid;
    }

    /**
     * @return The course
     */
    public String getCourse() {
        return course;
    }

    /**
     * @param course The course
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * @return The faculty
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * @param faculty The faculty
     */
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
     * @return The facultyOid
     */
    public Integer getFacultyOid() {
        return facultyOid;
    }

    /**
     * @param facultyOid The facultyOid
     */
    public void setFacultyOid(Integer facultyOid) {
        this.facultyOid = facultyOid;
    }

    /**
     * @return The formOfEducation
     */
    public String getFormOfEducation() {
        return formOfEducation;
    }

    /**
     * @param formOfEducation The formOfEducation
     */
    public void setFormOfEducation(String formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    /**
     * @return The groupOid
     */
    public Integer getGroupOid() {
        return groupOid;
    }

    /**
     * @param groupOid The groupOid
     */
    public void setGroupOid(Integer groupOid) {
        this.groupOid = groupOid;
    }

    /**
     * @return The kindOfEducation
     */
    public Integer getKindOfEducation() {
        return kindOfEducation;
    }

    /**
     * @param kindOfEducation The kindOfEducation
     */
    public void setKindOfEducation(Integer kindOfEducation) {
        this.kindOfEducation = kindOfEducation;
    }

    /**
     * @return The number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number The number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return The speciality
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * @param speciality The speciality
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return number;
    }
}