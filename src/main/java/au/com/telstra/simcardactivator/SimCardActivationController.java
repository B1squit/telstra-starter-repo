package au.com.telstra.simcardactivator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimCardActivationController {

    private static final Logger log = LoggerFactory.getLogger(SimCardActivationController.class);
    
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    // Sends post request to authentication microservice and returns success as String object
    @PostMapping("/activate")
    public Result activate(@RequestBody SimCard simCard, RestTemplate restTemplate) throws Exception {

        Result result = restTemplate.postForObject(
                        "http://localhost:8444/actuate", 
                            simCard,
                Result.class);

        log.info(result.toString());

        return result;
    }

}
