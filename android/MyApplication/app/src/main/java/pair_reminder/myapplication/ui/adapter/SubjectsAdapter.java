package pair_reminder.myapplication.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import pair_reminder.myapplication.R;
import pair_reminder.myapplication.models.Subject;
import pair_reminder.myapplication.ui.SubjectsViewHolder;
import pair_reminder.myapplication.ui.utils.SubjectListUtils;

public class SubjectsAdapter extends ArrayAdapter<Subject> {
    public SubjectsAdapter(Context context, int resource, List<Subject> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SubjectsViewHolder viewHolder;
        if (convertView == null) {
            Log.d("ADAPTER", "CREATE VIEW");
            convertView = LayoutInflater.from(getContext())
                    .inflate(getItemViewType(position) == 0 ?
                                    R.layout.list_item_subject : R.layout.list_item_subject
                            , parent, false);

            viewHolder = new SubjectsViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (SubjectsViewHolder) convertView.getTag();

        final Subject item = getItem(position);
        SubjectListUtils.fillSubjectListItem(viewHolder, item);
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
}
