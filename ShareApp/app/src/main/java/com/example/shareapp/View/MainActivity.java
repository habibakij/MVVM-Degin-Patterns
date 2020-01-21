package com.example.shareapp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shareapp.Model.LoginEntityData;
import com.example.shareapp.R;
import com.example.shareapp.ViewModel.LoginViewModel;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private Button logIn;
    private EditText loginEmail, loginPassword;
    LoginViewModel loginViewModel;
    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        loginViewModel= ViewModelProviders.of(this).get(LoginViewModel.class);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveData();
                if (count>0) {
                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    public void Init(){
        logIn= findViewById(R.id.login_button);
        loginEmail= findViewById(R.id.login_email);
        loginPassword= findViewById(R.id.login_password);
    }

    public void SaveData(){
        String id= UUID.randomUUID().toString();
        int check= loginViewModel.loginValidityCheck(loginEmail.getText().toString(), loginPassword.getText().toString());
        if (check == 0){
            Toast.makeText(this, "Must enter your email", Toast.LENGTH_SHORT).show();
        }
        if (check == 1){
            Toast.makeText(this, "Enter valid email address", Toast.LENGTH_SHORT).show();
        }
        if (check == 2){
            Toast.makeText(this, "password at least 6 char long", Toast.LENGTH_SHORT).show();
        }
        if (check == 3){
            count++;
            LoginEntityData loginEntityData= new LoginEntityData(id, loginEmail.getText().toString());
            loginViewModel.insert(loginEntityData);
            Toast.makeText(this, "You are able to create notification", Toast.LENGTH_SHORT).show();
        }

    }
}
