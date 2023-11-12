package de.bcxp.school.devops.troubleshooting.presents;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@EnableScheduling
public class PresentDataUpdater {

    private final String behaviorDataEndpoint = "http://localhost:8080/api/behavior-data";
    private final PresentDatabase presentDatabase;
    private final RestTemplate restTemplate;
    private final Storage storage;

    @Autowired
    public PresentDataUpdater(PresentDatabase presentDatabase, Storage storage) {
        this.presentDatabase = presentDatabase;
        this.restTemplate = new RestTemplate();
        this.storage = storage;
    }

    @Scheduled(fixedDelay = 10000) // Poll every 10 seconds
    public void updatePresentData() {
        storage.init();
        PresentData[] presentDataArray = restTemplate.getForObject(behaviorDataEndpoint, PresentData[].class);

        if (presentDataArray != null) {
            for (PresentData presentData : presentDataArray) {
                if (presentDatabase.getAllPresentData().stream().anyMatch(p -> p.getName().equals(presentData.getName()))) {
                    continue;
                }
                // Update presents in Storage based on numPresents
                updateStoragePresents(presentData);
                presentDatabase.addPresentData(presentData);
            }
        }
    }

    private void updateStoragePresents(PresentData presentData) {
        int numPresents = presentData.getNumPresents();
        List<String> availablePresents = storage.getPresents();
        List<String> sendPresents = presentData.getPresents();
        for (int i = 0; i < numPresents && !availablePresents.isEmpty(); i++) {
            String present = availablePresents.get(0);
            sendPresents.add(present);
            availablePresents.remove(0);
        }
    }
}
