package de.bcxp.school.devops.troubleshooting.common;
// UserData.java
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserData {

    @JsonProperty("full_name") // Map 'name' property to 'full_name' in JSON
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd") // Specify the date format
    private String birthday;

    @JsonIgnore // Exclude this property from JSON serialization
    private int someInternalData;

    // Empty constructor
    public UserData() {
    }

    // Constructor with name and birthday
    public UserData(String name, String birthday) {
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

    public void setSomeInternalData(int someInternalData) {
        this.someInternalData = someInternalData;
    }

    // Constructors, getters, and toString method...

    @Override
    public String toString() {
        return "UserData{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", someInternalData=" + someInternalData +
                '}';
    }
}
