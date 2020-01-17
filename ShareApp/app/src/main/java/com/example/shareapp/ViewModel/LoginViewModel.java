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
            return 1;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(loginModel.getEmail()).matches()) {
            return 2;
        } else if (loginModel.getPassword().length() <= 6) {
            return 3;
        } else {
            return 4;
        }
    }
}
