package pair_reminder.myapplication.models;

import java.util.List;

public class Institute {
    private String name;
    private List<Group> groups;

    public Institute(String name, List<Group> groups) {
        this.groups = groups;
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
