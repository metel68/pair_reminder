package pair_reminder.myapplication.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.squareup.otto.Bus;

import pair_reminder.myapplication.app.App;
import pair_reminder.myapplication.rest.RetrofitHelper;

public abstract class BaseFragment extends Fragment {
    private RetrofitHelper retrofitHelper;
    private Bus bus;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus = App.getApp(this).getBus();
        retrofitHelper = new RetrofitHelper();

    }

    @Override
    public void onStart() {
        super.onStart();
        bus.register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        bus.unregister(this);
    }

    public Bus getBus() {
        return bus;
    }


    public RetrofitHelper getRetrofitHelper() {
        return retrofitHelper;
    }
}
