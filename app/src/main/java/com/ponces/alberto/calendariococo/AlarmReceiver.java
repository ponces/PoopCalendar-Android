package com.ponces.alberto.calendariococo;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
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
        showNotification();
        java.util.Calendar c = java.util.Calendar.getInstance();
        int hour = 8, minute = 0, second = 0;
        c.set(java.util.Calendar.HOUR_OF_DAY, hour);
        c.set(java.util.Calendar.MINUTE, minute);
        c.set(java.util.Calendar.SECOND, second);
        AlarmManager am = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),
                PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 0));

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
        } else {
            builder.setContentTitle(context.getString(R.string.like));
            builder.setContentText(description);
        }
        builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        builder.setVibrate(new long[] {0, 250, 250, 250});
        builder.setAutoCancel(true);

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pending = PendingIntent.getActivity(context,
                0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pending);

        NotificationManager manager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}
