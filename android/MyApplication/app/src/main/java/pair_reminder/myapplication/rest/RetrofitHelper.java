package pair_reminder.myapplication.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pair_reminder.myapplication.app.BusProvider;
import pair_reminder.myapplication.models.Group;
import pair_reminder.myapplication.models.Subject;
import pair_reminder.myapplication.models.SubjectsList;
import pair_reminder.myapplication.rest.api.ScheduleApi;
import pair_reminder.myapplication.rest.responces.GroupsResponse;
import pair_reminder.myapplication.rest.responces.InstitutesResponse;
import pair_reminder.myapplication.rest.responces.ScheduleResponse;
import pair_reminder.myapplication.ui.events.DayScheduleLoadedEvent;
import pair_reminder.myapplication.ui.events.GroupsLoadedEvent;
import pair_reminder.myapplication.ui.events.InstitutesLoadedEvent;
import pair_reminder.myapplication.ui.events.WeekScheduleLoadedEvent;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RetrofitHelper {
    private static final String BASE_URL = "http://10.0.2.2:9998";

    public void getSchedule(final Map<String, String> options) {
        getApi()
                .getSchedule(options, new Callback<ScheduleResponse>() {
                    @Override
                    public void success(ScheduleResponse response, Response response1) {
                        ArrayList<Subject> subjects = new ArrayList<>();
                        List<SubjectsList> allSubjects = response.getSubjectsList();
                        for (SubjectsList weekSubjects : allSubjects) {
                            List<Subject> daySubjects = weekSubjects.getSubjects();
                            for (Subject subject : daySubjects) {
                                subjects.add(subject);
                            }
                        }

                        if (options.get("date") == null) {
                            BusProvider.getInstance().post(new WeekScheduleLoadedEvent(subjects));
                        } else {
                            BusProvider.getInstance().post(new DayScheduleLoadedEvent(subjects));
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
    }

    public void getInstitutes() {
        getApi()
                .getInstitutes(new Callback<InstitutesResponse>() {
                    @Override
                    public void success(InstitutesResponse response, Response response1) {
                        List<String> institutes = response.getInstitutes();
                        BusProvider.getInstance().post(new InstitutesLoadedEvent(institutes));
                    }

                    @Override
                    public void failure(RetrofitError error) {


                    }
                });
    }

    public void getGroups(String institute) {
        getApi()
                .getGroups(institute, new Callback<GroupsResponse>() {
                    @Override
                    public void success(GroupsResponse response, Response response1) {
                        List<Group> groups = response.getGroups();
                        BusProvider.getInstance().post(new GroupsLoadedEvent(groups));
                    }

                    @Override
                    public void failure(RetrofitError error) {


                    }
                });
    }

    public void getGroups(String institute, String course) {
        getApi()
                .getGroups(institute, course, new Callback<GroupsResponse>() {
                    @Override
                    public void success(GroupsResponse response, Response response1) {
                        List<Group> groups = response.getGroups();
                        BusProvider.getInstance().post(new GroupsLoadedEvent(groups));
                    }

                    @Override
                    public void failure(RetrofitError error) {


                    }
                });
    }


    private ScheduleApi getApi() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        return restAdapter.create(ScheduleApi.class);
    }


}
