package de.bcxp.school.devops.troubleshooting.app2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component
@EnableScheduling
public class ChildDataPoller {

    private final RestTemplate restTemplate;

    public ChildDataPoller() {
        this.restTemplate = new RestTemplate();
    }

    @Scheduled(fixedRate = 10000) // Poll every 10 seconds
    public void pollChildrenData() {
        String childDataUrl = "http://localhost:8080/children"; // URL of the first Spring Boot app
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(childDataUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String responseBody = responseEntity.getBody();

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                List<ChildData> children = objectMapper.readValue(responseBody, new TypeReference<List<ChildData>>() {});

                System.out.println("List of children from http://localhost:8080/children:");
                for (ChildData child : children) {
                    System.out.println(child);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to retrieve children from http://localhost:8080/children. Status code: " + responseEntity.getStatusCode());
        }
    }
}
