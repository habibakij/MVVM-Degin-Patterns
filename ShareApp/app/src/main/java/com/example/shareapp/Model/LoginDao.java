package com.example.shareapp.Model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LoginDao {
    @Query("SELECT * FROM loginTable")
    List<LoginDataModel> getAllData();

    @Insert
    void insert(LoginDataModel loginDataModel);
}
