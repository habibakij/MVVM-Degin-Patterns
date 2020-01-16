package com.example.shareapp.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "loginTable")
public class LoginDataModel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "userEmail")
    private String userEmail;

    @ColumnInfo(name = "finished")
    private boolean finished;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
