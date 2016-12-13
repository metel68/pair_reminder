package pair_reminder.myapplication.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.squareup.otto.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import pair_reminder.myapplication.R;
import pair_reminder.myapplication.ui.base.BaseFragment;
import pair_reminder.myapplication.ui.events.SchedulePickedEvent;

/**
 * A simple {@link Fragment} subclass.
 */
public class SchedulePickerContainerFragment extends BaseFragment {


    @BindView(R.id.fragments_container)
    FrameLayout fragmentsContainer;

    public SchedulePickerContainerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule_picker_container, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragments_container, new SchedulePickerFragment())
                .commit();
    }

    @Subscribe
    public void onSchedulePickedEvent(SchedulePickedEvent event) {
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragments_container, ScheduleFragment.newInstance(event.getGroup(), event.getDate()))
                .commit();
    }
}
