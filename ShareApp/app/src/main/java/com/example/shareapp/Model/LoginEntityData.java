package com.example.shareapp.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "loginTable")
public class LoginEntityData {

    @PrimaryKey()
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
