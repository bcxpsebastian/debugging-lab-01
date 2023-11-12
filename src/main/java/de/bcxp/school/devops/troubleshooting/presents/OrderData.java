package de.bcxp.school.devops.troubleshooting.presents;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderData {

    @JsonProperty("full_name")
    private String name;

    @JsonProperty("num_presents")
    private int numPresents;

    // Constructors, getters, and toString method...

    // Empty constructor
    public OrderData() {
    }

    // Constructor with name and numPresents
    public OrderData(String name, int numPresents) {
        this.name = name;
        this.numPresents = numPresents;
    }

    // Property setters
    public void setName(String name) {
        this.name = name;
    }

    public void setNumPresents(int numPresents) {
        this.numPresents = numPresents;
    }

    @Override
    public String toString() {
        return "OrderData{" +
                "name='" + name + '\'' +
                ", numPresents=" + numPresents +
                '}';
    }
}
