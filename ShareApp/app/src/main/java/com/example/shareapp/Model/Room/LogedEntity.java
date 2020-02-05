package com.example.shareapp.Model.Room;

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

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "userName")
    private String userName;

    @ColumnInfo(name = "userEmail")
    private String userEmail;

    public LogedEntity(@NonNull String id, String name, String userName, String userEmail) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
