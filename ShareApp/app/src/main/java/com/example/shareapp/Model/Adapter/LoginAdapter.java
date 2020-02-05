package com.example.shareapp.Model.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shareapp.Model.Room.LogedEntity;
import com.example.shareapp.R;

import java.util.List;

public class LoginAdapter extends RecyclerView.Adapter<LoginAdapter.LoginViewHolder> {
    private Context mContext;
    private List<LogedEntity> logedEntityData;

    public LoginAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public LoginViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new LoginViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoginViewHolder holder, int position) {
        if (logedEntityData != null) {
            LogedEntity mLoginModel = logedEntityData.get(position);
            holder.ShowEmail.setText(mLoginModel.getUserEmail());
            Log.d("what happend",holder.ShowEmail.getText().toString());
        }else {
            holder.ShowEmail.setText("your database is empty");
        }
    }

    @Override
    public int getItemCount() {
        if (logedEntityData != null) {
            return logedEntityData.size();
        }else {
            return 0;
        }
    }

    public void setLoginData(List<LogedEntity> loginData){
        logedEntityData = loginData;
        notifyDataSetChanged();
    }

    public class LoginViewHolder extends RecyclerView.ViewHolder {
        TextView ShowEmail;

        public LoginViewHolder(@NonNull View itemView) {
            super(itemView);
            ShowEmail= itemView.findViewById(R.id.showEmail);
        }
    }
}