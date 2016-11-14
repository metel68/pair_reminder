package pair_reminder.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SearchResponse {

    @SerializedName("list")
    @Expose
    private java.util.List<SubjectsList> subjectsList = new ArrayList<>();
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("error")
    @Expose
    private Error error;

    /**
     * @return The subjectsList
     */
    public java.util.List<SubjectsList> getSubjectsList() {
        return subjectsList;
    }

    /**
     * @param subjectsList The subjectsList
     */
    public void setSubjectsList(java.util.List<SubjectsList> subjectsList) {
        this.subjectsList = subjectsList;
    }

    /**
     * @return The success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * @param success The success
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * @return The error
     */
    public Error getError() {
        return error;
    }

    /**
     * @param error The error
     */
    public void setError(Error error) {
        this.error = error;
    }

}