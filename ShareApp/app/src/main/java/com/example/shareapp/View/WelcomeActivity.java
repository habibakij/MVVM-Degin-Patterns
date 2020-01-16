package com.example.shareapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.example.shareapp.Model.LoginDataModel;
import com.example.shareapp.Model.LoginFetchData;
import com.example.shareapp.R;

import java.util.List;

public class WelcomeActivity extends AppCompatActivity {
    private TextView textViewShowRoomdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textViewShowRoomdata= findViewById(R.id.textviewShowRoomdata);

        GetAllData();
    }
    public void GetAllData(){
        class AllData extends AsyncTask<Void, Void, List<LoginDataModel>> {

            @Override
            protected List<LoginDataModel> doInBackground(Void... voids) {

                List<LoginDataModel> loginDataModels= LoginFetchData.getInstance(getApplicationContext())
                        .getLoginDatabase().loginDOA().getAllData();

                return loginDataModels;
            }

            @Override
            protected void onPostExecute(List<LoginDataModel> loginDataModels) {
                super.onPostExecute(loginDataModels);
                textViewShowRoomdata.setText(loginDataModels.toString());
            }
        }
        AllData allData= new AllData();
        allData.execute();
    }
}
