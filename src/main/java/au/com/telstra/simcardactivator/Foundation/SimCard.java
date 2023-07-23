package au.com.telstra.simcardactivator.Foundation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class SimCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    protected String iccid;
    protected String customerEmail;
    protected boolean activated;

    protected SimCard() {}

    public SimCard (String iccid, String customerEmail, boolean activated) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
        this.activated = activated;
    }

    @JsonIgnore
    public Long getId() {
        return this.id;
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
