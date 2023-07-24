package stepDefinitions;

import au.com.telstra.simcardactivator.SimCardActivator;
import au.com.telstra.simcardactivator.Foundation.SimCard;
import io.cucumber.java.en.*;
import io.cucumber.spring.CucumberContextConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;
    private String iccid;
    private SimCard simCard;
    private SimCard retSimCard;

    @Given("the sim card iccid {string} is valid")
    public void set_valid_iccid (String iccid) {
        this.simCard = new SimCard(iccid, "");
        this.iccid = iccid;
    }

    @Given("the sim card iccid {string} is not valid")
    public void set_invalid_iccid (String iccid) {
        this.simCard = new SimCard(iccid, "");
        this.iccid = iccid;
    }

    @And("that it is activated through {string}")
    public void activate_iccid(String resource) {
        restTemplate.postForObject("http://localhost:8080/" + resource, 
                                    simCard, 
                                    SimCard.class);
    }

    @When("I query {string} with id {int}")
    public void request_simCard(String resource, int id) {
        retSimCard = restTemplate.getForObject("http://localhost:8080/" + resource 
                                                + "?simCardId=" + id,
                                    SimCard.class);
    }

    @Then("the sim card should be activated")
    public void check_activated() {
        assertEquals(iccid, retSimCard.getIccid());
        assertTrue(retSimCard.getActivated());
    }

    @Then("the sim card should not be activated")
    public void check_not_activated() {
        assertEquals(iccid, retSimCard.getIccid());
        assertFalse(retSimCard.getActivated());
    }

}
