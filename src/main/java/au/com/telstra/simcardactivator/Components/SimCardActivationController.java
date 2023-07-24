package au.com.telstra.simcardactivator.Components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import au.com.telstra.simcardactivator.Foundation.Result;
import au.com.telstra.simcardactivator.Foundation.SimCard;
import au.com.telstra.simcardactivator.Repository.SimCardEntity;
import au.com.telstra.simcardactivator.Repository.SimCardRepository;

@RestController
public class SimCardActivationController {

    private static final Logger log = LoggerFactory.getLogger(SimCardActivationController.class);
    private final SimCardRepository simCardRepository;
    private final RestTemplate restTemplate;

    public SimCardActivationController(RestTemplateBuilder builder, SimCardRepository simCardRepository) {
        this.restTemplate = builder.build();
        this.simCardRepository = simCardRepository;
    }
    
    // Sends post request to authentication microservice and returns success as String object
    @PostMapping("/activate")
    public Result activate(@RequestBody SimCard simCard) {

        Result result = restTemplate.postForObject("http://localhost:8444/actuate", simCard, Result.class);
        log.info(result.toString());

        simCard.setActivated(result.getSuccess());
        simCardRepository.save(new SimCardEntity(simCard));

        return result;
    }

    @GetMapping("/getSimCard")
    public SimCard getSimCard(@RequestParam long simCardId) {
        return new SimCard(simCardRepository.findById(simCardId));
    }

}
