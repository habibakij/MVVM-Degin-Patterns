package com.example.shareapp.ContentProvider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.example.shareapp.Model.SQLite.SQLiteHelper;

public class MyContentProvider extends ContentProvider {
    private static final UriMatcher URI_MATCHER;
    private static final String AUTHORITY_URI= "shareapp";
    private static final String URI_STRING= "content://"+AUTHORITY_URI;
    public static final Uri CONTENT_URI= Uri.parse(URI_STRING);
    private SQLiteDatabase sqLiteDatabase;
    private SQLiteHelper sqLiteHelper;

    static {
        URI_MATCHER= new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(AUTHORITY_URI,SQLiteHelper.LOGIN_CONTENT_PROVIDER_TABLE ,1);
        URI_MATCHER.addURI(AUTHORITY_URI, SQLiteHelper.LOGIN_CONTENT_PROVIDER_TABLE+"#",2);
    }

    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID= sqLiteDatabase.insert(SQLiteHelper.LOGIN_CONTENT_PROVIDER_TABLE, null, values);
        Uri insertUri= Uri.parse(CONTENT_URI+SQLiteHelper.LOGIN_CONTENT_PROVIDER_TABLE+"/"+rowID);
        return insertUri;
    }

    @Override
    public boolean onCreate() {
        sqLiteHelper= new SQLiteHelper(getContext());
        sqLiteDatabase= sqLiteHelper.getWritableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch (URI_MATCHER.match(uri)) {
            case 1:
                Cursor cursor = sqLiteDatabase.query(SQLiteHelper.LOGIN_CONTENT_PROVIDER_TABLE,
                        projection, selection, selectionArgs, sortOrder, null, null);
                return cursor;
            case 2:
                String id = uri.getLastPathSegment();
                Cursor cursor1 = sqLiteDatabase.query(SQLiteHelper.LOGIN_CONTENT_PROVIDER_TABLE, projection,
                        SQLiteHelper.LOGIN_COLOUM_ID + " ?", new String[]{id}, null, null, null);
                return cursor1;
            default:
                try {
                    throw new IllegalAccessException("Invalid uri exception");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
        }
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
