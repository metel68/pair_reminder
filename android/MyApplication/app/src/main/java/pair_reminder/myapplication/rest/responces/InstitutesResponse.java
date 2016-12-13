package pair_reminder.myapplication.rest.responces;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InstitutesResponse {

    @SerializedName("list")
    @Expose
    private java.util.List<String> institutes = null;
    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("error")
    @Expose
    private Error error;

    /**
     * @return The institutes
     */
    public List<String> getInstitutes() {
        return institutes;
    }

    /**
     * @param institutes The institutes
     */
    public void setInstitutes(List<String> institutes) {
        this.institutes = institutes;
    }

    /**
     * @return The success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success The success
     */
    public void setSuccess(boolean success) {
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