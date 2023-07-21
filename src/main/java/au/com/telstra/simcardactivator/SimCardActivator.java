package au.com.telstra.simcardactivator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SimCardActivator {

    private static final Logger log = LoggerFactory.getLogger(SimCardActivator.class);
    
    public static void main(String[] args) {
        SpringApplication.run(SimCardActivator.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    // Sends post request to authentication microservice and returns success as String object
    @PostMapping("/activate")
    public String activate(@RequestBody Record record, RestTemplate restTemplate) throws Exception {

        String success = restTemplate.postForObject(
                        "http://localhost:8444/actuate", 
                            new Iccid(record.getIccid()),
                String.class);

        log.info(success);

        return success;
    }

}
