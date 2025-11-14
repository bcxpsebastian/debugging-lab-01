package de.bcxp.school.devops.troubleshooting.presents;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Storage {

    private List<String> presents;
    
    @Value("${config.value}")
    private String configValue;

    public Storage() {}

    public List<String> getPresents() {
        return presents;
    }

    public void init() {
        if (presents == null) {
            presents = generatePresents(getConfigValue());
        }
    }

    private List<String> generatePresents(int configValue) {
        List<String> generatedPresents = new ArrayList<>();
        ChristmasPresentGenerator presentGenerator = new ChristmasPresentGenerator();

        for (int i = 0; i < configValue; i++) {
            String present = presentGenerator.generatePresentName();
            generatedPresents.add(present);
        }

        return generatedPresents;
    }

    private int getConfigValue() {
        return Integer.parseInt(new String(Base64.getDecoder().decode(configValue)));
    }
}
