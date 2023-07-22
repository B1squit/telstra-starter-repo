package au.com.telstra.simcardactivator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Wrapper class to break down incoming JSON file
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimCard {

    private String iccid;
    private String customerEmail;

    public SimCard() {}

    public SimCard (String iccid, String customerEmail) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getIccid() {
        return this.iccid;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerEmail() {
        return this.customerEmail;
    }

    @Override
    public String toString() {
        return "iccid: " + iccid + ", customerEmail: " + customerEmail;
    }

 }
