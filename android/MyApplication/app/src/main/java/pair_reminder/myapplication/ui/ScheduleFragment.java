package pair_reminder.myapplication.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import pair_reminder.myapplication.R;
import pair_reminder.myapplication.models.Subject;
import pair_reminder.myapplication.ui.adapter.SubjectsAdapter;
import pair_reminder.myapplication.ui.base.BaseFragment;
import pair_reminder.myapplication.ui.events.DayScheduleLoadedEvent;
import pair_reminder.myapplication.ui.events.SelectedFragmentChangedEvent;
import pair_reminder.myapplication.ui.events.WeekScheduleLoadedEvent;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends BaseFragment {

    private static final String ARG_DATE = "ARG_DATE";
    private static final String ARG_GROUP = "ARG_GROUP";
    @BindView(R.id.subjects)
    ListView subjectsListView;
    private ArrayList<Subject> subjectArrayList = new ArrayList<>();
    private SubjectsAdapter subjectsAdapter;
    private String group;
    private String date;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    public static ScheduleFragment newInstance(String group) {
        ScheduleFragment fragment = new ScheduleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_GROUP, group);
        fragment.setArguments(args);
        return fragment;
    }

    public static ScheduleFragment newInstance(String group, String date) {
        ScheduleFragment fragment = new ScheduleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_GROUP, group);
        args.putString(ARG_DATE, date);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            group = getArguments().getString(ARG_GROUP);
            date = getArguments().getString(ARG_DATE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        subjectsAdapter = new SubjectsAdapter(getActivity(), 0, subjectArrayList);
        subjectsListView.setAdapter(subjectsAdapter);

        sendRequestForSchedule(group, date);
    }

    private void sendRequestForSchedule(String group, String date) {
        Map<String, String> searchOptions = new HashMap<>();
        searchOptions.put("group", group);
        searchOptions.put("date", date);

        getRetrofitHelper().getSchedule(searchOptions);
    }

    @Subscribe
    public void onWeekScheduleLoadedEvent(WeekScheduleLoadedEvent event) {
        if (date == null) {
            updateView(event.getSubjects());
        }
    }

    @Subscribe
    public void onDayScheduleLoadedEvent(DayScheduleLoadedEvent event) {
        if (date != null) {
            updateView(event.getSubjects());
        }
    }

    @Subscribe
    public void onSelectedFragmentChanged(SelectedFragmentChangedEvent event) {

    }

    private void updateView(ArrayList<Subject> subjects) {
        subjectArrayList.clear();
        subjectArrayList.addAll(subjects);
        subjectsAdapter.notifyDataSetChanged();
    }
}
