package pair_reminder.myapplication.API;


import android.database.Observable;

import java.util.List;

import pair_reminder.myapplication.model.SearchResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface ScheduleApi {
    @GET("/api/lessons")
    void getResponse(@Query("group") String searchString, Callback<SearchResponse> callback);


    List<SearchResponse> getResponseSync(@Query("group") String searchString);

    @GET("/api/lessons")
    Observable<List<SearchResponse>> getObservableResponse(@Query("group") String searchString);
}
