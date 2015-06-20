package com.ponces.alberto.calendariococo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by alberto on 19/06/15.
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context, AlarmService.class);
        intent.putExtra("description", context.getString(R.string.description));
        context.startService(service);
        context.stopService(service);
    }
}
