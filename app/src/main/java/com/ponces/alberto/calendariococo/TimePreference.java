package com.ponces.alberto.calendariococo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.preference.DialogPreference;
import android.preference.PreferenceManager;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by alberto on 22/06/15.
 */
public class TimePreference extends DialogPreference {

    private Context context;
    private java.util.Calendar calendar;
    private TimePicker picker = null;

    public TimePreference(Context ctxt) {
        this(ctxt, null);
        this.context = ctxt;
    }

    public TimePreference(Context ctxt, AttributeSet attrs) {
        this(ctxt, attrs, android.R.attr.dialogPreferenceStyle);
        this.context = ctxt;
    }

    public TimePreference(Context ctxt, AttributeSet attrs, int defStyle) {
        super(ctxt, attrs, defStyle);
        this.context = ctxt;

        setPositiveButtonText(R.string.ok);
        setNegativeButtonText(R.string.cancel);
        calendar = new GregorianCalendar();
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
            }
        }

        java.util.Calendar c = java.util.Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("HH");
        if(Integer.parseInt(df.format(new Date())) > 10) {

        }
        c.setTimeInMillis(System.currentTimeMillis());
        String[] time = "23:00".split(":");
        c.set(java.util.Calendar.HOUR_OF_DAY, Integer.parseInt(time[0]));
        c.set(java.util.Calendar.MINUTE, Integer.parseInt(time[1]));
        c.set(java.util.Calendar.SECOND, 00);
        System.out.println("Time: " + c.getTimeInMillis());
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
        String[] time = PreferenceManager.getDefaultSharedPreferences(context)
                .getString("notification_hour", "08:00").split(":");
        c.set(java.util.Calendar.HOUR_OF_DAY, Integer.parseInt(time[0]));
        c.set(java.util.Calendar.MINUTE, Integer.parseInt(time[1]));
        c.set(java.util.Calendar.SECOND, 0);
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 24 * 60 * 60 * 1000,
                PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 0));
    }

    public void cancelNotification() {
        AlarmManager am = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
        am.cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 0));
    }
}