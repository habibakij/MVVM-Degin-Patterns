package com.example.shareapp.ViewModel;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.example.shareapp.Model.LoginModel;
import com.example.shareapp.View.MainActivity;

import java.util.regex.Pattern;

public class LoginViewModel extends ViewModel {

    private LoginModel loginModel;
    private Context mContext;

    public void logindata(String email, String password) {
        loginModel = new LoginModel(email, password);
    }

    public int IsValidData() {
        if (TextUtils.isEmpty(loginModel.getEmail())) {
            Toast.makeText(mContext, "you must enter email", Toast.LENGTH_SHORT).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(loginModel.getEmail()).matches()) {
            Toast.makeText(mContext, "enter valid email", Toast.LENGTH_SHORT).show();
        } else if (loginModel.getPassword().length() <= 6) {
            Toast.makeText(mContext, "password have must 6 char long", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "Login successfully", Toast.LENGTH_SHORT).show();
            return 1;
        }
        return 0;
    }
}
