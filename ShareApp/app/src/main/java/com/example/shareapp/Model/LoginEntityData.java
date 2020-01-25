package com.example.shareapp.Model;

import android.provider.BaseColumns;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = LoginEntityData.LOGIN_TABLE_NAME)
public class LoginEntityData {

    public static final String LOGIN_TABLE_NAME="loginTable";

    //public static final String ID= BaseColumns._ID;

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private String id;

    @ColumnInfo(name = "userEmail")
    private String userEmail;

    public LoginEntityData(@NonNull String id, String userEmail) {
        this.id = id;
        this.userEmail = userEmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
