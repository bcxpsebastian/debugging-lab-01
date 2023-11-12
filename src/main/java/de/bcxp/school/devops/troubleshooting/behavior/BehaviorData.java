package de.bcxp.school.devops.troubleshooting.behavior;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BehaviorData {

    @JsonProperty("full_name")
    private String name;

    @JsonProperty("behavior")
    private Behavior behavior;

    // Empty constructor
    public BehaviorData() {
    }

    // Constructor with name and behavior
    public BehaviorData(String name, Behavior behavior) {
        this.name = name;
        this.behavior = behavior;
    }

    // Property setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    // Constructors, getters, and toString method...

    @Override
    public String toString() {
        return "ChildData{" +
                "name='" + name + '\'' +
                ", behavior=" + behavior +
                '}';
    }
}
