package com.example.listviewlp2223.Tools;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listviewlp2223.Model.Task;
import com.example.listviewlp2223.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView tvId, tvTitle, tvDescription;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        tvId = itemView.findViewById(R.id.tvId);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvDescription = itemView.findViewById(R.id.tvDescription);
    }

    void display(Task task) {
        tvId.setText(task.getId());
        tvTitle.setText(task.getTitle());
        tvDescription.setText(task.getDescription());
    }
}
