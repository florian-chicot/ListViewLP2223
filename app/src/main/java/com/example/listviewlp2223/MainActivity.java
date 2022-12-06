package com.example.listviewlp2223;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.listviewlp2223.Model.Task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Task> data = new ArrayList<>();
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addTask(View view) {
        data.add(new Task(index, "Task no."+index, "Description of Task no."+index, false));
        index++;
        Log.d("MyLogs", "After the add");
    }
}