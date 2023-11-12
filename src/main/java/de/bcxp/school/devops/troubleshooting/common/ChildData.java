package de.bcxp.school.devops.troubleshooting.common;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ChildData {

    @JsonProperty("full_name") // Map 'name' property to 'full_name' in JSON
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd") // Specify the date format
    private String birthday;

    // Empty constructor
    public ChildData() {
    }

    // Constructor with name and birthday
    public ChildData(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    // Property setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    // Constructors, getters, and toString method...

    @Override
    public String toString() {
        return "ChildData{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
