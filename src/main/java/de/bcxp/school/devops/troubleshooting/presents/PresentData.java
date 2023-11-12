package de.bcxp.school.devops.troubleshooting.presents;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class PresentData {

    @JsonProperty("full_name")
    private String name;

    @JsonProperty("num_presents")
    private int numPresents;

    @JsonProperty("presents")
    private List<String> presents = new ArrayList<>(); // List of presents

    // Constructors, getters, and toString method...

    // Empty constructor
    public PresentData() {
    }

    // Constructor with name, numPresents, and presents
    public PresentData(String name, int numPresents, List<String> presents) {
        this.name = name;
        this.numPresents = numPresents;
        this.presents = presents;
    }

    // Property setters
    public void setName(String name) {
        this.name = name;
    }

    public void setNumPresents(int numPresents) {
        this.numPresents = numPresents;
    }

    public void setPresents(List<String> presents) {
        this.presents = presents;
    }

    // Getter for the number of presents
    public int getNumPresents() {
        return numPresents;
    }

    public List<String> getPresents() {
        return presents;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PresentData{" +
                "name='" + name + '\'' +
                ", numPresents=" + numPresents +
                ", presents=" + presents +
                '}';
    }
}
