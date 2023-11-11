package de.bcxp.school.devops.troubleshooting.demo2;
// DemoApplication2.java
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.bcxp.school.devops.troubleshooting.common.UserData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class DemoApplication2 {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoApplication2.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
        app.run(args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Scheduled(fixedRate = 10000) // Poll every 10 seconds
    public void pollUserData() {
        String userDataUrl = "http://localhost:8080/users"; // URL of the first Spring Boot app
        ResponseEntity<String> responseEntity = restTemplate().getForEntity(userDataUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String responseBody = responseEntity.getBody();

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                List<UserData> users = objectMapper.readValue(responseBody, new TypeReference<List<UserData>>() {});

                System.out.println("List of Users from http://localhost:8080/users:");
                for (UserData user : users) {
                    System.out.println(user);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to retrieve users from http://localhost:8080/users. Status code: " + responseEntity.getStatusCode());
        }
    }
}
