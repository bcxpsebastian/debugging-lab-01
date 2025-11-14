package de.bcxp.school.devops.troubleshooting.behavior;

import org.springframework.stereotype.Component;

@Component
public class PresentsCalculator {

    public BehaviorData calculatePresents(BehaviorData behaviorData) {
        Behavior behavior = behaviorData.getBehavior();
        int behaviorValue = behavior.getValue();
        
        // Calculate the number of presents
        int numPresents = 5 - behaviorValue;

        // Set the calculated numPresents in the BehaviorData
        behaviorData.setNumPresents(numPresents);

        return behaviorData;
    }
}
