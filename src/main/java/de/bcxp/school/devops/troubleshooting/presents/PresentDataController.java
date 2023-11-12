package de.bcxp.school.devops.troubleshooting.presents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/presentdata")
public class PresentDataController {

    private final PresentDatabase presentDatabase;

    @Autowired
    public PresentDataController(PresentDatabase presentDatabase) {
        this.presentDatabase = presentDatabase;
    }

    @GetMapping
    public List<PresentData> getAllPresentData() {
        return presentDatabase.getAllPresentData();
    }
}
