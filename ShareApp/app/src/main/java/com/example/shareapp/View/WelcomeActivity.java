package com.example.shareapp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.shareapp.Model.Adapter.LoginAdapter;
import com.example.shareapp.Model.LoginEntityData;
import com.example.shareapp.R;
import com.example.shareapp.ViewModel.LoginViewModel;

import java.util.List;

public class WelcomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LoginViewModel loginViewModel;
    private LoginAdapter loginAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        /*recyclerView= findViewById(R.id.recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        loginAdapter= new LoginAdapter(this);

        loginViewModel= ViewModelProviders.of(this).get(LoginViewModel.class);
        loginViewModel.getAllData().observe(this, new Observer<List<LoginEntityData>>() {
            @Override
            public void onChanged(List<LoginEntityData> loginEntityData) {
                loginAdapter.setLoginData(loginEntityData);
            }
        });
        recyclerView.setAdapter(loginAdapter);*/
    }
}
