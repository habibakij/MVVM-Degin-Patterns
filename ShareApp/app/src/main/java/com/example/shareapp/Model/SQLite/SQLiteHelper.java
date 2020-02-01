package com.example.shareapp.Model.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String LOGIN_CONTENT_PROVIDER_DATABASE="content_provider_database";
    public static final String LOGIN_CONTENT_PROVIDER_TABLE="content_provider_table";
    public static final String LOGIN_COLOUM_ID="id";
    public static final String LOGIN_COLOUM_EMAIL="email";
    public static final String LOGIN_COLOUM_CURRENT_TIME="currentTime";

    public SQLiteHelper(@Nullable Context context) {
        super(context, LOGIN_CONTENT_PROVIDER_DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACTS_TABLE = ("CREATE TABLE " + LOGIN_CONTENT_PROVIDER_TABLE + "(" + LOGIN_COLOUM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                LOGIN_COLOUM_EMAIL + " TEXT," + LOGIN_COLOUM_CURRENT_TIME + " TEXT" + ")");
        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+LOGIN_CONTENT_PROVIDER_TABLE);
        onCreate(sqLiteDatabase);
    }
}
