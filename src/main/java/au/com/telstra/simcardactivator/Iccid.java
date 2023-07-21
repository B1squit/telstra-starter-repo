package au.com.telstra.simcardactivator;

// Wrapper class for POST request in SimCardController
public class Iccid {
    
    String iccid;

    public Iccid (String iccid) {
        this.iccid = iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getIccid() {
        return this.iccid;
    }
}
