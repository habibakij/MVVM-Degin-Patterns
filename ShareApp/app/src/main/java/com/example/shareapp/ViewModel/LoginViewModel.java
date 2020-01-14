package com.example.shareapp.ViewModel;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.lifecycle.ViewModel;

import com.example.shareapp.Model.LoginModel;

import java.util.regex.Pattern;

public class LoginViewModel extends ViewModel {

    private LoginModel loginModel;

    public void logindata(String email, String password) {
        loginModel = new LoginModel(email, password);

        /*public void setUserEmail (String emaili){
            loginModel.setEmail(email);
        }

        public String getUserEmail () {
            return loginModel.getEmail();
        }

        public void setUserPassword (String password){
            loginModel.setPassword(password);
        }

        public String getUserPassword () {
            return loginModel.getPassword();
        }*/
    }

    public int IsValidData() {
        if (TextUtils.isEmpty(loginModel.getEmail())) {
            return 1;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(loginModel.getEmail()).matches()) {
            return 2;
        } else if (loginModel.getPassword().length() <= 6) {
            return 3;
        }
        return -1;
    }
}
