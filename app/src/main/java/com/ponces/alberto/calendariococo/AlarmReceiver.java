package com.ponces.alberto.calendariococo;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alberto on 19/06/15.
 */
public class AlarmReceiver extends BroadcastReceiver {

    private Context context;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean enabled = sharedPreferences.getBoolean("switch_notifications", true);
        if(enabled) {
            showNotification();
            if(Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
                java.util.Calendar c = java.util.Calendar.getInstance();
                c.setTimeInMillis(System.currentTimeMillis());
                c.set(java.util.Calendar.HOUR_OF_DAY, 8);
                c.set(java.util.Calendar.MINUTE, 0);
                c.set(java.util.Calendar.SECOND, 0);
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                long timeChosen = PreferenceManager.getDefaultSharedPreferences(context)
                        .getLong("notification_hour", c.getTimeInMillis());
                am.setRepeating(AlarmManager.RTC_WAKEUP, timeChosen, 24 * 60 * 60 * 1000,
                        PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 0));
            }
        }
    }

    private void showNotification() {
        Controller ctrl = new Controller(context);
        ctrl.searchDay("today");
        String description = ctrl.getDescription();
        SimpleDateFormat df = new SimpleDateFormat("dd");
        int day = Integer.parseInt(df.format(new Date()));
        NotificationCompat.Builder builder;
        builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.drawable.base_cozinho);
        if (day == 9) {
            builder.setContentTitle(context.getString(R.string.congratulations));
            builder.setContentText(context.getString(R.string.like) + " " + description);
            builder.setStyle(new NotificationCompat.BigTextStyle()
                    .bigText(context.getString(R.string.like) + " " + description));
        } else {
            builder.setContentTitle(context.getString(R.string.like));
            builder.setContentText(description);
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(description));
        }
        builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        builder.setVibrate(new long[] {0, 250, 250, 250});
        builder.setAutoCancel(true);

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pending = PendingIntent.getActivity(context,
                0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pending);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}
