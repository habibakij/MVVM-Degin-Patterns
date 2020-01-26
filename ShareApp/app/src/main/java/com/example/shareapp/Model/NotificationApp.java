package com.example.shareapp.Model;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class NotificationApp extends Application {
    public static final String channel= "Channel";

    @Override
    public void onCreate() {
        super.onCreate();

        CreateNotificationChennal();
    }

    public void CreateNotificationChennal() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channe_one = new NotificationChannel(
                    channel, "chennal one", NotificationManager.IMPORTANCE_HIGH
            );
            channe_one.setDescription("this is notification one");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channe_one);

        }
    }
}
