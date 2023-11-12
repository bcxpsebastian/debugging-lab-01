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

    public void setPresentData(List<PresentData> presentData) {
        presentDataList = presentData;
    }

    public List<PresentData> getAllPresentData() {
        return presentDataList;
    }
}
