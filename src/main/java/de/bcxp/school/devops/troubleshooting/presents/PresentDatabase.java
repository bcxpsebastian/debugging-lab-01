package de.bcxp.school.devops.troubleshooting.presents;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PresentDatabase {

    private List<PresentData> presentDataList;

    public PresentDatabase() {
        this.presentDataList = new ArrayList<>();
    }

    public void addPresentData(PresentData presentData) {
        presentDataList.add(presentData);
    }

    public List<PresentData> getAllPresentData() {
        return presentDataList;
    }
}
