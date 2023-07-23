package au.com.telstra.simcardactivator.Foundation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Wrapper class for POST request in SimCardController
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    
    Boolean success;

    public Result() {}

    public Result (Boolean success) {
        this.success = success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    @Override
    public String toString() {
        return "success: " + success;
    }
}
