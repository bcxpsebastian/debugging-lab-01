package de.bcxp.school.devops.troubleshooting.user;
// UserData.java
public class UserData {

    private String name;
    private String birthday;

    public UserData(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    // Getters and setters (or lombok annotations) here

    @Override
    public String toString() {
        return "UserData{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
