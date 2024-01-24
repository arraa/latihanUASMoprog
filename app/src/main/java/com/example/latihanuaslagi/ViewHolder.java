package com.example.latihanuaslagi;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView id, name, pass, email;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.tvId);
        name = itemView.findViewById(R.id.tvName);
        pass = itemView.findViewById(R.id.tvPasswrd);
        email = itemView.findViewById(R.id.tvEmail);
    }
}
