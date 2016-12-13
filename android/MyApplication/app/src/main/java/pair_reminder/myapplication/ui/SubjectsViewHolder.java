package pair_reminder.myapplication.ui;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pair_reminder.myapplication.R;

public class SubjectsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_subject)
    TextView tvSubject;
    @BindView(R.id.tv_teacher)
    TextView tvTeacher;
    @BindView(R.id.tv_room)
    TextView tvRoom;
    @BindView(R.id.tv_group)
    TextView tvGroup;

    public SubjectsViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public TextView getTvGroup() {
        return tvGroup;
    }

    public TextView getTvRoom() {
        return tvRoom;
    }

    public TextView getTvSubject() {
        return tvSubject;
    }

    public TextView getTvTeacher() {
        return tvTeacher;
    }

    public TextView getTvTime() {
        return tvTime;
    }
}

