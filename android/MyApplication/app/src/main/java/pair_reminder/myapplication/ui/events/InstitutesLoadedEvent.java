package pair_reminder.myapplication.ui.events;

import java.util.List;

public class InstitutesLoadedEvent {
    private List<String> institutes;

    public InstitutesLoadedEvent(List<String> institutes) {
        this.institutes = institutes;
    }

    public List<String> getInstitutes() {
        return institutes;
    }
}
