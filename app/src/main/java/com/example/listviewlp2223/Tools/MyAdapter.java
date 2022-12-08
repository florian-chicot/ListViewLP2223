package com.example.listviewlp2223.Tools;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listviewlp2223.Model.Task;
import com.example.listviewlp2223.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Task> localData = new ArrayList<>();
    private static InterfaceMyListener myListener;

    public static void setMyListener(InterfaceMyListener myListener) {
        MyAdapter.myListener = myListener;
    }

    public MyAdapter(List<Task> l) {
        localData = l;
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

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private TextView tvId, tvTitle, tvDescription;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        void display(Task task) {
            tvId.setText(task.getId() + "");
            tvTitle.setText(task.getTitle());
            tvDescription.setText(task.getDescription());
        }

        @Override
        public void onClick(View view) {
            myListener.onItemClick(getAdapterPosition(), view);
        }

        @Override
        public boolean onLongClick(View view) {
            myListener.onItemLongClick(getAdapterPosition(), view);
            return false;
        }
    }
}
