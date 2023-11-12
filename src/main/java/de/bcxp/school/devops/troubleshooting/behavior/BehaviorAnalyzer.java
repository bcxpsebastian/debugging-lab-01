package de.bcxp.school.devops.troubleshooting.behavior;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component
@EnableScheduling
public class BehaviorAnalyzer {

    private final RestTemplate restTemplate;
    private final BehaviorDatabase behaviorDatabase;

    @Autowired
    public BehaviorAnalyzer(BehaviorDatabase behaviorDatabase) {
        this.restTemplate = new RestTemplate();
        this.behaviorDatabase = behaviorDatabase;
    }

    @Scheduled(fixedRate = 10000) // Poll every 10 seconds
    public void pollChildrenData() {
        String childDataUrl = "http://localhost:8080/children"; // URL of the first Spring Boot app
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(childDataUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String responseBody = responseEntity.getBody();

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                List<BehaviorData> children = objectMapper.readValue(responseBody, new TypeReference<List<BehaviorData>>() {});

                // Update the behavior data in the database
                behaviorDatabase.updateBehaviorData(children);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to retrieve children from http://localhost:8080/children. Status code: " + responseEntity.getStatusCode());
        }
    }
}
