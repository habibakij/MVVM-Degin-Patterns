package com.example.shareapp.Model.Room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = SecondAppEntity.SECONDAPP_TABLE_NAME)
public class SecondAppEntity {
    public static final String SECONDAPP_TABLE_NAME="secondAppEntity";

    @PrimaryKey
    @NonNull
    private String s_id;

    @ColumnInfo(name = "second_email")
    private String second_email;

    @ColumnInfo(name = "currentTime")
    private String currentTime;

    public SecondAppEntity(@NonNull String s_id, String second_email, String currentTime) {
        this.s_id = s_id;
        this.second_email = second_email;
        this.currentTime = currentTime;
    }

    @NonNull
    public String getS_id() {
        return s_id;
    }

    public void setS_id(@NonNull String s_id) {
        this.s_id = s_id;
    }

    public String getSecond_email() {
        return second_email;
    }

    public void setSecond_email(String second_email) {
        this.second_email = second_email;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}
