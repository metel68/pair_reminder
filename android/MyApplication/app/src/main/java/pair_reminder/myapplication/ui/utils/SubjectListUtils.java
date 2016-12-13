package pair_reminder.myapplication.ui.utils;


import pair_reminder.myapplication.models.Subject;
import pair_reminder.myapplication.ui.SubjectsViewHolder;

public class SubjectListUtils {
    public static void fillSubjectListItem(SubjectsViewHolder viewHolder, Subject item) {
        viewHolder.getTvTime().setText(String.format("%s\n%s", item.getStartTime(), item.getEndTime()));
        viewHolder.getTvSubject().setText(item.getSubjectName());
        viewHolder.getTvTeacher().setText(item.getTeacher());
        viewHolder.getTvRoom().setText(item.getRoom());
        viewHolder.getTvGroup().setText(item.getGroup());
    }
}
