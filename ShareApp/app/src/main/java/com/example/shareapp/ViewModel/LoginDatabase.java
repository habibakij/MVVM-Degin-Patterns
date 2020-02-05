package com.example.shareapp.ViewModel;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.shareapp.Model.Room.LoginDao;
import com.example.shareapp.Model.Room.LogedEntity;
import com.example.shareapp.Model.Room.SecondAppEntity;

@Database(entities = {LogedEntity.class, SecondAppEntity.class}, version = 2, exportSchema = false)
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
