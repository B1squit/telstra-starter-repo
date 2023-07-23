package au.com.telstra.simcardactivator.Repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import au.com.telstra.simcardactivator.Foundation.SimCard;

@Entity
public class SimCardEntity {
    
    @Id
    @GeneratedValue()
    private long id;

    @Column(nullable = false)
    private String iccid;

    @Column(nullable = false)
    private String customerEmail;

    @Column(nullable = false)
    private boolean activated;

    protected SimCardEntity() {}

    public SimCardEntity(SimCard simCard) {
        this.iccid = simCard.getIccid();
        this.customerEmail = simCard.getCustomerEmail();
        this.activated = simCard.getActivated();
    }

    public long getId() {
        return id;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getIccid() {
        return iccid;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setActivated(boolean active) {
        this.activated = active;
    }

    public boolean getActivated() {
        return activated;
    }
}
