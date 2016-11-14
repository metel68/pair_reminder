package pair_reminder.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pair_reminder.myapplication.API.ScheduleApi;
import pair_reminder.myapplication.model.SearchResponse;
import pair_reminder.myapplication.model.Subject;
import pair_reminder.myapplication.model.SubjectsList;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    public static final String SEARCH_STRING = "444";
    private static final String BASE_URL = "http://10.0.2.2:9998";
    @BindView(R.id.tv_subjects)
    TextView tvSubjects;
    @BindView(R.id.btn_get_subjects)
    Button btnGetSubjects;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void retrofitsCallback() {
        getApi()
                .getResponse(SEARCH_STRING, new Callback<SearchResponse>() {
                    @Override
                    public void success(SearchResponse response, Response response1) {
                        Calendar calendar = Calendar.getInstance();
                        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                        String currentDate = dateFormat.format(calendar.getTime());

                        List<SubjectsList> subjectsList = response.getSubjectsList();

                        for (int i = 0; i < subjectsList.size(); i++) {
                            List<Subject> subjects = subjectsList.get(i).getSubjects();
                            for (int j = 0; j < subjects.size(); j++) {
                                String subjectDate = subjects.get(j).getDate();
                                if (subjectDate.equals(currentDate)) {
                                    tvSubjects.append(subjects.get(j).toString());
                                }
                            }
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        System.out.println(error.toString());
                    }
                });
    }

    @OnClick(R.id.btn_get_subjects)
    public void onClick() {
        tvSubjects.setText("");
        retrofitsCallback();
    }

    private ScheduleApi getApi() {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        return restAdapter.create(ScheduleApi.class);
    }
}
