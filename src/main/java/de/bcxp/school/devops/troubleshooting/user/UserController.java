package de.bcxp.school.devops.troubleshooting.user;
// UserController.java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UserController {

    @GetMapping
    public String showForm() {
        return "index";
   }

    @PostMapping("/submitForm")
    public String submitForm(@RequestParam String name, @RequestParam String birthday) {
        UserData userData = new UserData(name, birthday);
        System.out.println("Received data: " + userData);
        return "redirect:/";
    }
}
