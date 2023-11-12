package de.bcxp.school.devops.troubleshooting.behavior;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/behavior-data")
public class BehaviorDataController {

    private final BehaviorDatabase behaviorDatabase;

    @Autowired
    public BehaviorDataController(BehaviorDatabase behaviorDatabase) {
        this.behaviorDatabase = behaviorDatabase;
    }

    @GetMapping
    public List<BehaviorData> getAllBehaviorData() {
        return behaviorDatabase.getAllBehaviorData();
    }
}
