package com.example.listviewlp2223;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.listviewlp2223.Model.Task;
import com.example.listviewlp2223.Tools.InterfaceMyListener;
import com.example.listviewlp2223.Tools.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Task> data = new ArrayList<>();
    private int index = 0;
    private LinearLayoutManager linearLayoutManager;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        myAdapter = new MyAdapter(data);
        recyclerView.setAdapter(myAdapter);
        MyAdapter.setMyListener(new InterfaceMyListener() {
            @Override
            public void onItemClick(int position, View view) {
                Task task = data.get(position);
                new AlertDialog.Builder(view.getContext())
                        .setTitle(task.getTitle())
                        .setMessage(task.getDescription())
                        .show();
            }

            @Override
            public void onItemLongClick(int position, View view) {
                data.remove(position);
                myAdapter.notifyItemChanged(position);
            }
        });
    }

    public void addTask(View view) {
        data.add(new Task(index, "Task no."+index, "Description of Task no."+index, false));
        index++;
        myAdapter.notifyDataSetChanged();
        Log.d("MyLogs", "After the add");
    }
}