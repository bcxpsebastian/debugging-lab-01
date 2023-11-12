package de.bcxp.school.devops.troubleshooting.children;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ChildDatabase {

    private List<ChildData> children = new ArrayList<>();

    public void addChild(ChildData childData) {
        children.add(childData);
    }

    public List<ChildData> getAllChildren() {
        return children;
    }
}
