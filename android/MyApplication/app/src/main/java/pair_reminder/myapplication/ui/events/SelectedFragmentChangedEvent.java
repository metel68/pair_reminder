package pair_reminder.myapplication.ui.events;

public class SelectedFragmentChangedEvent {
    private int fragmentPosition;

    public SelectedFragmentChangedEvent(int fragmentPosition) {
        this.fragmentPosition = fragmentPosition;
    }

    public int getFragmentPosition() {
        return fragmentPosition;
    }
}
