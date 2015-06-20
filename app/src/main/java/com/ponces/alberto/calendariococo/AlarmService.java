package com.ponces.alberto.calendariococo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.PreferenceManager;

/**
 * Created by alberto on 19/06/15.
 */
public class AlarmService extends Service {

    private NotificationManager mManager;

    private String description;

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        description = intent.getExtras().getString("description", "cozinho");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this);
        String table = sharedPrefs.getString("table_list", "cozinho");
        int drawable;
        if(table.equals("cozinho")) {
            drawable = R.drawable.cozinho;
        } else {
            drawable = R.drawable.cozinha;
        }
        mManager = (NotificationManager) getApplicationContext().getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, MainActivity.class);

        Notification notification = new Notification(drawable,
                getString(R.string.app_name) + ": " + getString(R.string.like) + " " +
                        description, System.currentTimeMillis());
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingNotificationIntent = PendingIntent.getActivity(getApplicationContext(),
                0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.setLatestEventInfo(this.getApplicationContext(),
                getString(R.string.like), description, pendingNotificationIntent);
        mManager.notify(0, notification);
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
}
