package de.bcxp.school.devops.troubleshooting.presents;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Storage {

    private List<String> presents;
    
    @Value("${max.presents}")
    private int maxPresents;

    public Storage() {}

    public List<String> getPresents() {
        return presents;
    }

    public void init() {
        if (presents == null) {
            presents = generatePresents(maxPresents);
        }
    }

    private List<String> generatePresents(int totalPresents) {
        List<String> generatedPresents = new ArrayList<>();
        ChristmasPresentGenerator presentGenerator = new ChristmasPresentGenerator();

        for (int i = 0; i < totalPresents; i++) {
            String present = presentGenerator.generatePresentName();
            generatedPresents.add(present);
        }

        return generatedPresents;
    }
}
