package com.example.shareapp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.ViewModelProviders;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shareapp.Broadcast.MyNorifiReceiver;
import com.example.shareapp.Model.LoginEntityData;
import com.example.shareapp.R;
import com.example.shareapp.ViewModel.LoginViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import static com.example.shareapp.Model.NotificationApp.channel;

public class MainActivity extends AppCompatActivity {
    private Button logIn;
    private EditText loginEmail, loginPassword;
    LoginViewModel loginViewModel;
    private int count = 0;
    NotificationManagerCompat manager;
    private String currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        manager = NotificationManagerCompat.from(this);

        DateFormat df1 = new SimpleDateFormat("yyyy/MM/dd"); // Format date
        currentTime= df1.format(Calendar.getInstance().getTime());
    }

    public void LogIN(View view) {
        SaveData();
        if (count>0){
            Notifi();
            Intent intent= new Intent(this, WelcomeActivity.class);
            loginEmail.setText("");loginPassword.setText("");
            startActivity(intent);
            finish();

            /*PackageManager pm = MainActivity.this.getPackageManager();
            ComponentName componentName = new ComponentName(
                    MainActivity.this, MyNorifiReceiver.class);
            pm.setComponentEnabledSetting(componentName,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);*/


        }
    }

    public void Init() {
        logIn = findViewById(R.id.login_button);
        loginEmail = findViewById(R.id.login_email);
        loginPassword = findViewById(R.id.login_password);
    }

    public void SaveData() {
        String id = UUID.randomUUID().toString();
        int check = loginViewModel.loginValidityCheck(loginEmail.getText().toString(),
                loginPassword.getText().toString());
        if (check == 0) {
            Toast.makeText(this, "Must enter your email", Toast.LENGTH_SHORT).show();
        }
        if (check == 1) {
            Toast.makeText(this, "Enter valid email address", Toast.LENGTH_SHORT).show();
        }
        if (check == 2) {
            Toast.makeText(this, "Password at least 6 char long", Toast.LENGTH_SHORT).show();
        }
        if (check == 3) {
            count++;
            LoginEntityData loginEntityData = new LoginEntityData(id, loginEmail.getText().toString(), currentTime);
            loginViewModel.insert(loginEntityData);
            loginViewModel.InsertLocalDatabase(loginEmail.getText().toString().trim(), currentTime);
            Toast.makeText(this, "You are able to create notification", Toast.LENGTH_SHORT).show();
        }
    }

    public void Notifi() {
        /*DateFormat df1 = new SimpleDateFormat("yyyy/MM/dd");
        String currentTime = df1.format(Calendar.getInstance().getTime());*/
        Notification notification = new NotificationCompat.Builder(this, channel)
                .setSmallIcon(R.drawable.ic_account)
                .setContentTitle("Email: "+loginEmail.getText().toString())
                .setContentText("Time: "+currentTime)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        manager.notify(1, notification);
    }
}