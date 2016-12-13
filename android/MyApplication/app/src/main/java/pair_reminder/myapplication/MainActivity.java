package pair_reminder.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import pair_reminder.myapplication.ui.ScheduleFragment;
import pair_reminder.myapplication.ui.SchedulePickerContainerFragment;
import pair_reminder.myapplication.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {
    public static final String GROUP = "444";
    private static final SimpleDateFormat dateFormal = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    private String dateString;

    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dateString = dateFormal.format(Calendar.getInstance().getTime());

        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        ScheduleFragment oneDaySchedule = ScheduleFragment.newInstance(GROUP, dateString);
        ScheduleFragment weekSchedule = ScheduleFragment.newInstance(GROUP);

        adapter.addFragment(oneDaySchedule, "Today");
        adapter.addFragment(weekSchedule, "Week");
        adapter.addFragment(new SchedulePickerContainerFragment(), "Schedule picker");

        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragments = new ArrayList<>();
        private final List<String> titles = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            titles.add(title);
        }

        public void replaceFragment(int position, Fragment fragment) {
            fragments.set(position, fragment);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
