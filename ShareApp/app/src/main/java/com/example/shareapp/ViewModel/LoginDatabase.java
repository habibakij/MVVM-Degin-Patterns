package com.example.shareapp.ViewModel;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.shareapp.Model.LoginDao;
import com.example.shareapp.Model.LoginEntityData;

@Database(entities = {LoginEntityData.class}, version = 1, exportSchema = false)
public abstract class LoginDatabase extends RoomDatabase {
    public abstract LoginDao loginDao();

    private static volatile LoginDatabase loginDatabaseInstance;

    static LoginDatabase getLoginDatabase (Context mContext){
        if (loginDatabaseInstance == null){
            synchronized (LoginDatabase.class){
                if (loginDatabaseInstance == null){
                    loginDatabaseInstance= Room.databaseBuilder(mContext.getApplicationContext(),
                            LoginDatabase.class, "LoginNotification").fallbackToDestructiveMigration().build();
                }
            }
        }
        return loginDatabaseInstance;
    }
}
