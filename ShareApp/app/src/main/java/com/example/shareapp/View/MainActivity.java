package com.example.shareapp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shareapp.R;
import com.example.shareapp.Model.LoginModel;
import com.example.shareapp.ViewModel.LoginViewModel;

public class MainActivity extends AppCompatActivity {
    private Button logIn;
    private EditText loginEmail, loginPassword;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginViewModel= ViewModelProviders.of(this).get(LoginViewModel.class);

        logIn= findViewById(R.id.login_button);
        loginEmail= findViewById(R.id.login_email);
        loginPassword= findViewById(R.id.login_password);


        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= loginEmail.getText().toString();
                String password= loginPassword.getText().toString();
                loginViewModel.logindata(email, password);
                int isSuccess= loginViewModel.IsValidData();
                if (isSuccess == 1){
                    Toast.makeText(MainActivity.this, "you must enter email "+isSuccess, Toast.LENGTH_SHORT).show();
                } else if (isSuccess == 2){
                    Toast.makeText(MainActivity.this, "enter valid email", Toast.LENGTH_SHORT).show();
                } else if (isSuccess == 3){
                    Toast.makeText(MainActivity.this, "password have must 6 char long", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(MainActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

}
