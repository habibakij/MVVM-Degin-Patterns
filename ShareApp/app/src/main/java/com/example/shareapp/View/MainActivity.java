package com.example.shareapp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.ViewModelProviders;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shareapp.Broadcast.MyNorifiReceiver;
import com.example.shareapp.Model.Room.LogedEntity;
import com.example.shareapp.Model.Room.SecondAppEntity;
import com.example.shareapp.R;
import com.example.shareapp.ViewModel.LoginViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import static com.example.shareapp.Model.NotificationApp.channel;

public class MainActivity extends AppCompatActivity {
    private Button logIn;
    private EditText loginName, loginUserName,loginEmail, loginPassword;
    LoginViewModel loginViewModel;
    private int count = 0;
    NotificationManagerCompat manager;
    private String currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Home Activity");

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
            intent.putExtra("name",loginName.getText().toString());
            intent.putExtra("userName",loginUserName.getText().toString());
            intent.putExtra("email",loginEmail.getText().toString());
            intent.putExtra("password",loginPassword.getText().toString());
            loginName.setText("");loginUserName.setText("");loginEmail.setText("");loginPassword.setText("");
            startActivity(intent);
            finish();
        }
    }

    public void Init() {
        logIn = findViewById(R.id.login_button);
        loginName= findViewById(R.id.login_name);
        loginUserName= findViewById(R.id.login_userName);
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
            LogedEntity logedEntity = new LogedEntity(id, loginName.getText().toString(),
                    loginUserName.getText().toString(), loginEmail.getText().toString());
            SecondAppEntity secondAppEntity= new SecondAppEntity(id, loginEmail.getText().toString(), currentTime);

            loginViewModel.insert(logedEntity);
            loginViewModel.secondAppInsert(secondAppEntity);

            loginViewModel.InsertLocalDatabase(loginEmail.getText().toString().trim(), currentTime);
            Toast.makeText(this, "You are able to create notification", Toast.LENGTH_SHORT).show();
        }
    }

    public void Notifi() {
        /*DateFormat df1 = new SimpleDateFormat("yyyy/MM/dd");
        String currentTime = df1.format(Calendar.getInstance().getTime());*/
        Intent actvityIntent= new Intent(this, MainActivity.class);
        PendingIntent contentIntent= PendingIntent.getActivity(this, 0,
                actvityIntent, 0);
        Intent broadcastIntent= new Intent(this, MyNorifiReceiver.class);
        broadcastIntent.putExtra("toastmessage", "Broadcast hit successfully");
        PendingIntent actionIntent= PendingIntent.getBroadcast(this, 0, broadcastIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, channel)
                .setSmallIcon(R.drawable.ic_account)
                .setContentTitle("Email: "+loginEmail.getText().toString())
                .setContentText("Time: "+currentTime)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .setColor(Color.BLUE)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher, "Notifi", actionIntent)
                .build();
        manager.notify(1, notification);
    }
}