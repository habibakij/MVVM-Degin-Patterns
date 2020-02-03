package com.example.shareapp.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = LogedEntity.LOGIN_TABLE_NAME)
public class LogedEntity {
    public static final String LOGIN_TABLE_NAME="logedTable";

    @PrimaryKey()
    @NonNull
    private String id;

    @ColumnInfo(name = "userEmail")
    private String userEmail;

    @ColumnInfo(name = "currentTime")
    private String currentTime;

    public LogedEntity(String id, String userEmail, String currentTime) {
        this.id = id;
        this.userEmail = userEmail;
        this.currentTime = currentTime;
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

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}
