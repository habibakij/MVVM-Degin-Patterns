package com.example.shareapp.ViewModel;

import android.app.Application;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Patterns;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.shareapp.Model.LoginDao;
import com.example.shareapp.Model.LoginEntityData;
import com.example.shareapp.Model.LoginModel;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {
    private LoginDao loginDao;
    private LoginDatabase loginDatabase;
    private LiveData<List<LoginEntityData>> getAllLoginData;
    private LoginModel loginModel;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginDatabase= LoginDatabase.getLoginDatabase(application);
        loginDao= loginDatabase.loginDao();
        getAllLoginData= loginDao.getAllData();
    }

    public void insert(LoginEntityData loginEntityData){
        new LoginAsyntask(loginDao).execute(loginEntityData);
    }

    public LiveData<List<LoginEntityData>> getAllData(){
        return getAllLoginData;
    }

    public class LoginAsyntask extends AsyncTask<LoginEntityData, Void, Void> {
        LoginDao loginDao;

        public LoginAsyntask(LoginDao loginDao) {
            this.loginDao = loginDao;
        }

        @Override
        protected Void doInBackground(LoginEntityData... loginEntityData) {
            loginDao.insert(loginEntityData[0]);
            return null;
        }
    }


    public int loginValidityCheck(String email, String password) {
        loginModel = new LoginModel(email, password);
        if (TextUtils.isEmpty(loginModel.getEmail())) {
            return 0;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(loginModel.getEmail()).matches()) {
            return 1;
        } else if (loginModel.getPassword().length() < 6) {
            return 2;
        } else {
            return 3;
        }
    }
}
