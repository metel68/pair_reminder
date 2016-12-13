package pair_reminder.myapplication.ui.events;

import java.util.List;

import pair_reminder.myapplication.models.Group;

public class GroupsLoadedEvent {
    private List<Group> groups;

    public GroupsLoadedEvent(List<Group> groups) {
        this.groups = groups;
    }

    public List<Group> getGroups() {
        return groups;
    }
}
