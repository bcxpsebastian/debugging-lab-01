package de.bcxp.school.devops.troubleshooting.presents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@EnableScheduling
public class OrderDataUpdater {

    private final String behaviorDataEndpoint = "http://localhost:8080/api/behavior-data";
    private final OrderDatabase orderDatabase;
    private final RestTemplate restTemplate;

    @Autowired
    public OrderDataUpdater(OrderDatabase orderDatabase) {
        this.orderDatabase = orderDatabase;
        this.restTemplate = new RestTemplate();
    }

    @Scheduled(fixedDelay = 10000) // Poll every 10 seconds
    public void updateOrderData() {
        // Call the REST endpoint to retrieve OrderData objects directly
        OrderData[] orderDataArray = restTemplate.getForObject(behaviorDataEndpoint, OrderData[].class);

        // Save OrderData to the OrderDatabase
        if (orderDataArray != null) {
            for (OrderData orderData : orderDataArray) {
                System.out.println(orderData);
                orderDatabase.addOrderData(orderData);
            }
        }
    }

}
