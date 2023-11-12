package de.bcxp.school.devops.troubleshooting.children;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.bcxp.school.devops.troubleshooting.common.ChildData;

import java.util.List;

@Controller
@RequestMapping("/children")
public class ChildController {

    @Autowired
    private ChildDatabase childDatabase;

    @GetMapping
    public ResponseEntity<List<ChildData>> getAllChildren() {
        List<ChildData> children = childDatabase.getAllChildren();
        return ResponseEntity.ok(children);
    }

    @PostMapping("/submitForm")
    public String submitForm(@RequestParam String name, @RequestParam String birthday) {
        ChildData childData = new ChildData(name, birthday);
        childDatabase.addChild(childData);
        // Redirect to the index page after form submission
        return "index";
    }
}
