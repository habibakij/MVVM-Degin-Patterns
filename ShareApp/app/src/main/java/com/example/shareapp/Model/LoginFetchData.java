package com.example.shareapp.Model;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public class LoginFetchData {

    private LoginDatabase loginDatabase;
    private Context mContext;
    private static LoginFetchData loginFetchData;

    private LoginFetchData (Context ctx){
        this.mContext= ctx;
        loginDatabase= Room.databaseBuilder(ctx, LoginDatabase.class,"loginDatabase").allowMainThreadQueries().build();
    }

    public static synchronized LoginFetchData getInstance(Context context){
        if (loginFetchData==null){
            loginFetchData= new LoginFetchData(context);
        }
        return loginFetchData;
    }

    public LoginDatabase getLoginDatabase(){
        return loginDatabase;
    }
}
