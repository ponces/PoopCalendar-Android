package com.ponces.poopcalendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.preference.DialogPreference;
import android.preference.PreferenceManager;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TimePicker;

import java.util.*;

/**
 * Created by alberto on 22/06/15.
 */
public class TimePreference extends DialogPreference {

    private java.util.Calendar calendar;
    private TimePicker picker = null;

    public TimePreference(Context ctxt) {
        this(ctxt, null);
    }

    public TimePreference(Context ctxt, AttributeSet attrs) {
        this(ctxt, attrs, android.R.attr.dialogPreferenceStyle);
    }

    public TimePreference(Context ctxt, AttributeSet attrs, int defStyle) {
        super(ctxt, attrs, defStyle);
        setPositiveButtonText(R.string.ok);
        setNegativeButtonText(R.string.cancel);
        calendar = new GregorianCalendar();
        calendar.set(java.util.Calendar.HOUR_OF_DAY, 8);
        calendar.set(java.util.Calendar.MINUTE, 0);
    }

    @Override
    protected View onCreateDialogView() {
        picker = new TimePicker(getContext());
        picker.setIs24HourView(true);
        return (picker);
    }

    @Override
    protected void onBindDialogView(View v) {
        super.onBindDialogView(v);
        picker.setCurrentHour(calendar.get(java.util.Calendar.HOUR_OF_DAY));
        picker.setCurrentMinute(calendar.get(java.util.Calendar.MINUTE));
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
        super.onDialogClosed(positiveResult);

        if (positiveResult) {
            calendar.set(java.util.Calendar.HOUR_OF_DAY, picker.getCurrentHour());
            calendar.set(java.util.Calendar.MINUTE, picker.getCurrentMinute());

            setSummary(getSummary());
            if (callChangeListener(calendar.getTimeInMillis())) {
                persistLong(calendar.getTimeInMillis());
                notifyChanged();
                createNotification();
            }
        }
    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return (a.getString(index));
    }

    @Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {

        if (restoreValue) {
            if (defaultValue == null) {
                calendar.setTimeInMillis(getPersistedLong(System.currentTimeMillis()));
            } else {
                calendar.setTimeInMillis(Long.parseLong(getPersistedString((String) defaultValue)));
            }
        } else {
            if (defaultValue == null) {
                calendar.setTimeInMillis(System.currentTimeMillis());
            } else {
                calendar.setTimeInMillis(Long.parseLong((String) defaultValue));
            }
        }
        setSummary(getSummary());
    }

    @Override
    public CharSequence getSummary() {
        if (calendar == null) {
            return null;
        }
        return DateFormat.getTimeFormat(getContext()).format(new Date(calendar.getTimeInMillis()));
    }

    public void createNotification() {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        c.set(java.util.Calendar.HOUR_OF_DAY, 8);
        c.set(java.util.Calendar.MINUTE, 0);
        c.set(java.util.Calendar.SECOND, 0);
        long timeChosen = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getLong("notification_hour", c.getTimeInMillis());
        c.setTimeInMillis(timeChosen);
        if(java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY) > c.get(java.util.Calendar.HOUR_OF_DAY)) {
            timeChosen += 24 * 60 * 60 * 1000;
        } else {
            if(java.util.Calendar.getInstance().get(java.util.Calendar.MINUTE) > c.get(java.util.Calendar.MINUTE)) {
                timeChosen += 24 * 60 * 60 * 1000;
            }
        }
        AlarmManager am = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, timeChosen, 24 * 60 * 60 * 1000,
                PendingIntent.getBroadcast(getContext(), 0, new Intent(getContext(), AlarmReceiver.class), 0));
    }

    public void cancelNotification() {
        AlarmManager am = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
        am.cancel(PendingIntent.getBroadcast(getContext(), 0, new Intent(getContext(), AlarmReceiver.class), 0));
    }
}
