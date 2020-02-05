package com.example.shareapp.View;

import android.os.Bundle;

import com.example.shareapp.Model.Room.LogedEntity;
import com.example.shareapp.R;
import com.example.shareapp.ViewModel.LoginViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class WelcomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private TextView name, user_name, email, password;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Profile Activity");

        drawer= findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        name= findViewById(R.id.profile_name);
        user_name= findViewById(R.id.profile_userName);
        email= findViewById(R.id.profile_email);
        password= findViewById(R.id.profile_password);
        name.setText("Name: "+getIntent().getStringExtra("name"));
        user_name.setText("userName: "+getIntent().getStringExtra("userName"));
        email.setText("Email: "+getIntent().getStringExtra("email"));
        password.setText("Password: "+getIntent().getStringExtra("password"));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        String name, userName,email, password;
        name= getIntent().getStringExtra("name");
        userName= getIntent().getStringExtra("userName");
        email= getIntent().getStringExtra("email");
        password= getIntent().getStringExtra("password");
        int id= menuItem.getItemId();
        if (id== R.id.name){
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        } else if (id== R.id.username){
            Toast.makeText(this, userName, Toast.LENGTH_SHORT).show();
        } else if (id== R.id.email){
            Toast.makeText(this, email, Toast.LENGTH_SHORT).show();
        }else if (id== R.id.password){
            Toast.makeText(this, password, Toast.LENGTH_SHORT).show();
        } else if (id== R.id.setting){
            Toast.makeText(this, "This is setting", Toast.LENGTH_SHORT).show();
        } else if (id== R.id.share){
            Toast.makeText(this, "This is share", Toast.LENGTH_SHORT).show();
        } else if (id== R.id.logout){
            Toast.makeText(this, "This is log out", Toast.LENGTH_SHORT).show();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
