package com.example.shareapp.Broadcast;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.shareapp.R;

import static com.example.shareapp.Model.NotificationApp.channel;

public class MyNorifiReceiver extends BroadcastReceiver {
    NotificationManagerCompat manager;
    @Override
    public void onReceive(Context context, Intent intent) {

        /*manager= NotificationManagerCompat.from(context);

        Notification notification = new NotificationCompat.Builder(context, channel)
                .setSmallIcon(R.drawable.ic_account)
                .setContentTitle("Login notification")
                .setContentText("email:")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        manager.notify(1, notification);*/
    }
}
