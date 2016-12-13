package pair_reminder.myapplication.app;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.squareup.otto.Bus;

public class App extends Application {
    public Bus bus = BusProvider.getInstance();

    public static App getApp(Activity activity) {
        return (App) activity.getApplication();
    }

    public static App getApp(Fragment fragment) {
        final FragmentActivity activity = fragment.getActivity();
        if (activity != null)
            return (App) activity.getApplication();
        throw new IllegalStateException("Fragment must be attached to activity!");
    }

    public Bus getBus() {
        return bus;
    }
}