package de.bcxp.school.devops.troubleshooting.behavior;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BehaviorData {

    @JsonProperty("full_name")
    private String name;

    @JsonProperty("behavior")
    private Behavior behavior;

    @JsonProperty("num_presents")
    private int numPresents;

    // Empty constructor
    public BehaviorData() {
    }

    // Constructor with name, behavior, and numPresents
    public BehaviorData(String name, Behavior behavior, int numPresents) {
        this.name = name;
        this.behavior = behavior;
        this.numPresents = numPresents;
    }

    // Property setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    public void setNumPresents(int numPresents) {
        this.numPresents = numPresents;
    }

    // Constructors, getters, and toString method...

    @Override
    public String toString() {
        return "BehaviorData{" +
                "name='" + name + '\'' +
                ", behavior=" + behavior +
                ", numPresents=" + numPresents +
                '}';
    }

    public Behavior getBehavior() {
        return behavior;
    }
}
