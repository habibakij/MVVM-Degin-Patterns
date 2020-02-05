package com.example.shareapp.ViewModel;

import android.app.Application;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Patterns;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.shareapp.Model.Room.LoginDao;
import com.example.shareapp.Model.Room.LogedEntity;
import com.example.shareapp.Model.LoginModel;
import com.example.shareapp.Model.Room.SecondAppEntity;
import com.example.shareapp.Model.SQLite.SQLiteHelper;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {
    private LoginDao loginDao;
    private LoginDatabase loginDatabase;
    private LiveData<List<LogedEntity>> getAllLoginData;
    private LiveData<List<SecondAppEntity>> getAllSecondData;

    private LoginModel loginModel;
    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase sqLiteDatabase;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginDatabase= LoginDatabase.getLoginDatabase(application);
        loginDao= loginDatabase.loginDao();
        getAllLoginData= loginDao.getAllData();
        getAllSecondData= loginDao.getSecondAllData();
    }

    public void insert(LogedEntity logedEntity){
        new LoginAsyntask(loginDao).execute(logedEntity);
    }

    public void secondAppInsert(SecondAppEntity secondAppEntity){
        new SecondAppAsyntask(loginDao).execute(secondAppEntity);
    }

    public LiveData<List<LogedEntity>> getAllData(){
        return getAllLoginData;
    }

    public LiveData<List<SecondAppEntity>> getSecondAllData(){
        return getAllSecondData;
    }

    public class LoginAsyntask extends AsyncTask<LogedEntity, Void, Void> {
        LoginDao loginDao;

        public LoginAsyntask(LoginDao loginDao) {
            this.loginDao = loginDao;
        }

        @Override
        protected Void doInBackground(LogedEntity... logedEntity) {
            loginDao.insert(logedEntity[0]);
            return null;
        }
    }

    public class SecondAppAsyntask extends AsyncTask<SecondAppEntity, Void, Void>{

        LoginDao loginDao;
        public SecondAppAsyntask(LoginDao loginDao){
            this.loginDao = loginDao;
        }

        @Override
        protected Void doInBackground(SecondAppEntity... secondAppEntities) {
            loginDao.secondAppInsert(secondAppEntities[0]);
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

    public void InsertLocalDatabase(String email, String currentTime){
        sqLiteHelper= new SQLiteHelper(getApplication());
        sqLiteDatabase= sqLiteHelper.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(SQLiteHelper.LOGIN_COLOUM_EMAIL, email);
        contentValues.put(SQLiteHelper.LOGIN_COLOUM_CURRENT_TIME, currentTime);
        sqLiteDatabase.insert(SQLiteHelper.LOGIN_CONTENT_PROVIDER_TABLE, null, contentValues);
        sqLiteDatabase.close();
    }
}
