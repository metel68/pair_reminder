package pair_reminder.myapplication.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import pair_reminder.myapplication.R;
import pair_reminder.myapplication.models.Group;
import pair_reminder.myapplication.ui.base.BaseFragment;
import pair_reminder.myapplication.ui.events.DatePickedEvent;
import pair_reminder.myapplication.ui.events.GroupsLoadedEvent;
import pair_reminder.myapplication.ui.events.InstitutesLoadedEvent;
import pair_reminder.myapplication.ui.events.SchedulePickedEvent;
import pair_reminder.myapplication.ui.utils.DatePicker;


/**
 * A simple {@link Fragment} subclass.
 */
public class SchedulePickerFragment extends BaseFragment {


    @BindView(R.id.spr_institute)
    Spinner sprInstitute;
    @BindView(R.id.spr_course)
    Spinner sprCourse;
    @BindView(R.id.spr_group)
    Spinner sprGroup;
    @BindView(R.id.btn_date)
    Button btnDate;

    private ArrayList<String> institutes = new ArrayList<>();
    private ArrayList<Group> groups = new ArrayList<>();
    private ArrayList<String> courses = new ArrayList<>();

    private ArrayAdapter<String> institutesAdapter;
    private ArrayAdapter<Group> groupsAdapter;
    private ArrayAdapter<String> coursesAdapter;


    public SchedulePickerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule_picker, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        institutesAdapter = new ArrayAdapter<>(getContext(),
                R.layout.spinner_item, institutes);

        sprInstitute.setAdapter(institutesAdapter);

        groupsAdapter = new ArrayAdapter<>(getContext(),
                R.layout.spinner_item, groups);

        sprGroup.setAdapter(groupsAdapter);

        courses.add("1");
        courses.add("2");
        courses.add("3");
        courses.add("4");
        courses.add("5");
        courses.add("6");

        coursesAdapter = new ArrayAdapter<>(getContext(),
                R.layout.spinner_item, courses);
        sprCourse.setAdapter(coursesAdapter);

        sendRequestForInstitutes();
    }

    private void sendRequestForInstitutes() {
        getRetrofitHelper().getInstitutes();
    }

    @OnItemSelected(R.id.spr_institute)
    public void spinnerInstituteItemSelected(Spinner spinner, int position) {
        sendRequestForGroups((String) sprInstitute.getItemAtPosition(position));
    }

    @OnItemSelected(R.id.spr_course)
    public void spinnerCourseItemSelected(Spinner spinner, int position) {
        if (sprInstitute.getSelectedItem() == null) {
            return;
        }

        if (sprInstitute.getSelectedItem().equals("")) {
            return;
        }
        sendRequestForGroups((String) sprInstitute.getSelectedItem(), (String) sprCourse.getItemAtPosition(position));
    }

    private void sendRequestForGroups(String institute) {
        getRetrofitHelper().getGroups(institute);
    }

    private void sendRequestForGroups(String institute, String course) {
        getRetrofitHelper().getGroups(institute, course);
    }

    @OnItemSelected(R.id.spr_group)
    public void spinnerGroupItemSelected(Spinner spinner, int position) {
        spinner.getItemAtPosition(position);
    }

    @OnClick(R.id.btn_date)
    public void onClick() {
        DialogFragment dateDialog = new DatePicker();
        dateDialog.show(getChildFragmentManager(), "datePicker");
    }

    @Subscribe
    public void onDatePickedEvent(DatePickedEvent event) {
        getBus().post(new SchedulePickedEvent(event.getDate(),
                String.valueOf(((Group) sprGroup.getSelectedItem()).getGroupOid())));
    }

    @Subscribe
    public void onInstitutesLoadedEvent(InstitutesLoadedEvent event) {
        institutes.clear();
        institutes.addAll(event.getInstitutes());
        institutesAdapter.notifyDataSetChanged();
    }

    @Subscribe
    public void onGroupsLoadedEvent(GroupsLoadedEvent event) {
        groups.clear();
        groups.addAll(event.getGroups());
        groupsAdapter.notifyDataSetChanged();
    }
}
