package pair_reminder.myapplication.rest.api;


import java.util.Map;

import pair_reminder.myapplication.rest.responces.GroupsResponse;
import pair_reminder.myapplication.rest.responces.InstitutesResponse;
import pair_reminder.myapplication.rest.responces.ScheduleResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.http.QueryMap;

public interface ScheduleApi {
    @GET("/api/lessons")
    void getSchedule(@QueryMap Map<String, String> options, Callback<ScheduleResponse> callback);

    @GET("/api/faculties")
    void getInstitutes(Callback<InstitutesResponse> callback);

    @GET("/api/groups")
    void getGroups(@Query("faculty") String institute, Callback<GroupsResponse> callback);

    @GET("/api/groups")
    void getGroups(@Query("faculty") String institute, @Query("course") String course, Callback<GroupsResponse> callback);

}
