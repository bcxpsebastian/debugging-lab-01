package de.bcxp.school.devops.troubleshooting.app1.user;
// UserController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.bcxp.school.devops.troubleshooting.common.UserData;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDatabase userDatabase;

    @GetMapping
    public ResponseEntity<List<UserData>> getAllUsers() {
        List<UserData> users = userDatabase.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/submitForm")
    public String submitForm(@RequestParam String name, @RequestParam String birthday) {
        UserData userData = new UserData(name, birthday);
        userDatabase.addUser(userData);
        System.out.println("Received data: " + userData);
        // Redirect to the index page after form submission
        return "redirect:/";
    }
}
