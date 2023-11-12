package de.bcxp.school.devops.troubleshooting.behavior;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PresentsCalculator {

    @Value("${max.presents}")
    private int maxPresents;

    public BehaviorData calculatePresents(BehaviorData behaviorData) {
        Behavior behavior = behaviorData.getBehavior();
        int behaviorValue = behavior.getValue();
        
        // Calculate the number of presents
        int numPresents = maxPresents - behaviorValue;

        // Set the calculated numPresents in the BehaviorData
        behaviorData.setNumPresents(numPresents);

        return behaviorData;
    }
}
