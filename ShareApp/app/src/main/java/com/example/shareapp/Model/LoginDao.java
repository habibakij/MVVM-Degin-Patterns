package com.example.shareapp.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LoginDao {

    @Query("SELECT * FROM " + LogedEntity.LOGIN_TABLE_NAME)
    LiveData<List<LogedEntity>> getAllData();

    @Insert
    void insert(LogedEntity logedEntity);
}
