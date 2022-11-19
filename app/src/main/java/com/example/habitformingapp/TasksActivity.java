package com.example.habitformingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        ArrayList<String> list = new ArrayList<String>();
        ArrayAdapter<String> adapter;


        Intent i = getIntent();
        /*
        String taskName = i.getStringExtra("TASK_NAME");
        if(taskName != null) {
            ((ListView) findViewById(R.id.currentTasks)).setText(taskName);
        }

        /*


        String taskInterval = i.getStringExtra("TASK_INTERVAL");
        String taskDay = i.getStringExtra("TASK_DAY");
        String taskTime = i.getStringExtra("TASK_TIME");


        if(taskInterval != null) {
            ((TextView) findViewById(R.id.currentTasks)).setText(taskInterval);
        }
        if(taskDay != null) {
            ((TextView) findViewById(R.id.currentTasks)).setText(taskDay);
        }
        if(taskTime != null) {
            ((TextView) findViewById(R.id.currentTasks)).setText(taskTime);
        }

        */
    }


}