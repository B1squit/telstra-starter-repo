package au.com.telstra.simcardactivator.Foundation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import au.com.telstra.simcardactivator.Repository.SimCardEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SimCard {

    protected String iccid;
    protected String customerEmail;
    protected boolean activated;

    protected SimCard() {}

    public SimCard (String iccid, String customerEmail) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
    }

    public SimCard (String iccid, String customerEmail, boolean activated) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
        this.activated = activated;
    }

    public SimCard (SimCardEntity simCardEntity) {
        this.iccid = simCardEntity.getIccid();
        this.customerEmail = simCardEntity.getCustomerEmail();
        this.activated = simCardEntity.getActivated();
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

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public boolean getActivated() {
        return this.activated;
    }

    @Override
    public String toString() {
        return "iccid: " + iccid + ", customerEmail: " + customerEmail + ", activated: " + activated;
    }

}
