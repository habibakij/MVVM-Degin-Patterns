package com.example.shareapp.Model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {LoginDataModel.class}, version = 1)
public abstract class LoginDatabase extends RoomDatabase {

    public abstract LoginDao loginDao();
}
