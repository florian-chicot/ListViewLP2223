package com.example.listviewlp2223.Tools;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listviewlp2223.Model.Task;
import com.example.listviewlp2223.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    List<Task> localData = new ArrayList<>();

    public MyAdapter(List<Task> l) {
        super();
        localData.addAll(l);
    }

    // Create new views (invoked by layout manager)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view which defines tge UI of list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    // Replace the content of a view (invoked by layout manager)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Task task = localData.get(position);
        holder.display(task);
    }

    @Override
    public int getItemCount() {
        return localData.size();
    }
}
