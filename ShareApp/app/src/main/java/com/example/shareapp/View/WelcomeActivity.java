package com.example.shareapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shareapp.Model.LoginDataModel;
import com.example.shareapp.Model.LoginFetchData;
import com.example.shareapp.R;

import java.util.List;

public class WelcomeActivity extends AppCompatActivity {
    private TextView textViewShowRoomdata, notifiUserName;
    private String setNotifiUserName;
    private String pickUserName="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        notifiUserName= findViewById(R.id.notifiusername);
        textViewShowRoomdata= findViewById(R.id.textviewShowRoomdata);

        GetAllData();
    }
    public void GetAllData(){

        class AllData extends AsyncTask<Void, Void, LoginDataModel> {

            @Override
            protected LoginDataModel doInBackground(Void... voids) {

                LoginDataModel loginDataModels= LoginFetchData.getInstance(getApplicationContext())
                        .getLoginDatabase().loginDao().getAllData();

                return loginDataModels;
            }

            @Override
            protected void onPostExecute(LoginDataModel loginDataModels) {
                super.onPostExecute(loginDataModels);
                textViewShowRoomdata.setText(loginDataModels.getUserEmail());
                setNotifiUserName = textViewShowRoomdata.toString();
                try {
                    for (int i = 0; i <= setNotifiUserName.length(); i++) {
                        int index = setNotifiUserName.indexOf(setNotifiUserName.charAt(i));
                        if (index >= 0) {
                            char ch = setNotifiUserName.charAt(i);
                            if (ch == '@') {
                                break;
                            } else {
                                pickUserName += ch;
                            }
                        }
                    }
                } catch (Exception e) {
                    Log.d("Error", e.getMessage());
                }
                notifiUserName.setText(pickUserName);
            }
        }
        AllData allData = new AllData();
        allData.execute();
    }
}
