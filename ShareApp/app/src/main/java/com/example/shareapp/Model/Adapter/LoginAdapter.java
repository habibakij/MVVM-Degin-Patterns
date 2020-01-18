package com.example.shareapp.Model.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shareapp.Model.LoginDataModel;
import com.example.shareapp.R;
import com.example.shareapp.ViewModel.LoginViewModel;

import java.util.List;

public class LoginAdapter extends RecyclerView.Adapter<LoginAdapter.LoginViewHolder> {
    private Context mContext;
    private List<LoginDataModel> loginDataModels;

    public LoginAdapter(Context mContext, List<LoginDataModel> loginDataModels) {
        this.mContext = mContext;
        this.loginDataModels = loginDataModels;
    }

    @NonNull
    @Override
    public LoginViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new LoginViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoginViewHolder holder, int position) {
        LoginDataModel mLoginModel= loginDataModels.get(position);
        holder.ShowEmail.setText(mLoginModel.getUserEmail());
    }

    @Override
    public int getItemCount() {
        return loginDataModels.size();
    }

    public class LoginViewHolder extends RecyclerView.ViewHolder {
        TextView ShowEmail;

        public LoginViewHolder(@NonNull View itemView) {
            super(itemView);
            ShowEmail= itemView.findViewById(R.id.showEmail);
        }
    }
}