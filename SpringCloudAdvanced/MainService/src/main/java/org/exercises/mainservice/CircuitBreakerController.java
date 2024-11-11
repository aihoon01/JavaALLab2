package org.exercises.mainservice;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CircuitBreakerController {

    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("internal")
    @Retry(name = "Main-service-retry", fallbackMethod = "falcon")
    public String mainServicebreaker() {
        logger.info("Main Service breaker endpoint Simulated!!");

        // Intentionally calling an endpoint that does not exist
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8082/test-fail-url", String.class);
        return forEntity.getBody();
    }

    public String falcon(Exception ex) {
        logger.error("Fallback method activated due to: " + ex.getMessage());
        return "Fallback Method Activated: Main Service Breaker activated!";
    }
}

