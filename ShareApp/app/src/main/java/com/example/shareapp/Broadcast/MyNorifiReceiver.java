package com.example.shareapp.Broadcast;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.ViewModelProviders;

import com.example.shareapp.Model.LoginDao;
import com.example.shareapp.Model.LoginEntityData;
import com.example.shareapp.R;
import com.example.shareapp.ViewModel.LoginDatabase;
import com.example.shareapp.ViewModel.LoginViewModel;

import static com.example.shareapp.Model.NotificationApp.channel;

public class MyNorifiReceiver extends BroadcastReceiver {
    NotificationManagerCompat manager;
    LoginEntityData loginEntityData;
    @Override
    public void onReceive(Context context, Intent intent) {

        manager= NotificationManagerCompat.from(context);
        /*String uniquAction="android.intent.action.BOOT_COMPLETED";
        Intent broadcastIntent= new Intent(uniquAction);*/
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())){

            Notification notification = new NotificationCompat.Builder(context)
                    .setSmallIcon(R.drawable.ic_account)
                    .setContentTitle("Email: akijmia.cse@gmail.com")
                    .setContentText("Time: 2/2/2020/12:00")
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .build();
            manager.notify(1, notification);

            Toast.makeText(context, "match action", Toast.LENGTH_SHORT).show();
        }
    }
}
