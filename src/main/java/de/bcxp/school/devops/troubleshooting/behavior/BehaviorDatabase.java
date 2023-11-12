package de.bcxp.school.devops.troubleshooting.behavior;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BehaviorDatabase {

    private final PresentsCalculator presentsCalculator;
    private List<BehaviorData> behaviorDataList;

    @Autowired
    public BehaviorDatabase(PresentsCalculator presentsCalculator) {
        this.presentsCalculator = presentsCalculator;
        this.behaviorDataList = new ArrayList<>();
    }

    public void updateBehaviorData(List<BehaviorData> newBehaviorDataList) {
        // Clear the existing data
        behaviorDataList.clear();

        // Update each BehaviorData with numPresents using PresentsCalculator
        for (BehaviorData behaviorData : newBehaviorDataList) {
            BehaviorData updatedBehaviorData = presentsCalculator.calculatePresents(behaviorData);
            behaviorDataList.add(updatedBehaviorData);
        }
    }

    public List<BehaviorData> getAllBehaviorData() {
        return behaviorDataList;
    }
}
