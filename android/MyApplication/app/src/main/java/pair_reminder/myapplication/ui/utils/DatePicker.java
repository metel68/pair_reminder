package pair_reminder.myapplication.ui.utils;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Button;

import java.util.Calendar;

import pair_reminder.myapplication.app.BusProvider;
import pair_reminder.myapplication.ui.events.DatePickedEvent;

public class DatePicker extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        Dialog picker = new DatePickerDialog(getActivity(), this,
                year, month, day);
        picker.setTitle("Choose date");

        return picker;
    }

    @Override
    public void onStart() {
        super.onStart();
        // добавляем кастомный текст для кнопки
        Button btn = ((AlertDialog) getDialog())
                .getButton(DialogInterface.BUTTON_POSITIVE);
        btn.setText("OK");

    }

    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int year,
                          int month, int day) {
        BusProvider.getInstance().post(new DatePickedEvent(String.format("%d.%d.%d", day, (month + 1), year)));
    }
}
