package de.bcxp.school.devops.troubleshooting.app1.user;
// UserDatabase.java
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import de.bcxp.school.devops.troubleshooting.common.UserData;

@Service
public class UserDatabase {

    private List<UserData> users = new ArrayList<>();

    public void addUser(UserData userData) {
        users.add(userData);
    }

    public List<UserData> getAllUsers() {
        return users;
    }
}
