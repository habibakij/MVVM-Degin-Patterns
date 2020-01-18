package com.example.shareapp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shareapp.Model.Adapter.LoginAdapter;
import com.example.shareapp.Model.LoginDataModel;
import com.example.shareapp.Model.LoginFetchData;
import com.example.shareapp.R;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {

    RecyclerView recyclerView, recyclerView1;
    String setNotifiUserName;
    LoginAdapter loginAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        recyclerView= findViewById(R.id.reclerViewShowData);
        //recyclerView1= findViewById(R.id.reclerViewShowId);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        GetAllData();
    }
    public void GetAllData(){

        class AllData extends AsyncTask<Void, Void, List<LoginDataModel>> {

            @Override
            protected List<LoginDataModel> doInBackground(Void... voids) {

                List<LoginDataModel> loginDataModels= LoginFetchData.getInstance(getApplicationContext())
                        .getLoginDatabase().loginDao().getAllData();

                return loginDataModels;
            }

            @Override
            protected void onPostExecute(List<LoginDataModel> loginDataModels) {
                super.onPostExecute(loginDataModels);

                loginAdapter= new LoginAdapter(WelcomeActivity.this,loginDataModels);
                recyclerView.setAdapter(loginAdapter);

                /*textViewShowRoomdata.setText(loginDataModels.getUserEmail());
                setNotifiUserName = textViewShowRoomdata.getText().toString();
                String[] pickUserName= setNotifiUserName.split("@");
                notifiUserName.setText(String.valueOf(pickUserName[0]));*/

            }
        }
        AllData allData = new AllData();
        allData.execute();
    }
}
