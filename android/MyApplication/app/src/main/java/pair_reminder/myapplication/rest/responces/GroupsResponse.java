package pair_reminder.myapplication.rest.responces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import pair_reminder.myapplication.models.Group;

public class GroupsResponse {

    @SerializedName("list")
    @Expose
    private java.util.List<Group> groups = null;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("error")
    @Expose
    private Error error;

    /**
     * @return The groups
     */
    public java.util.List<Group> getGroups() {
        return groups;
    }

    /**
     * @param groups The groups
     */
    public void setGroups(java.util.List<Group> groups) {
        this.groups = groups;
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