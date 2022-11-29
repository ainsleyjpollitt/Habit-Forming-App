package com.example.habitformingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TaskInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_info);
        Intent i = getIntent();
        displayTaskDetails(i);
    }

    /* Print out the stored information on a task such
       as the name of the task or the time the task
       is done at onto the Task Details page.
    */
    public void displayTaskDetails(Intent i) {
        String taskName = i.getStringExtra("NAME");
        if(taskName == null) {
            ((TextView) findViewById(R.id.displayTaskName)).setText("No task name recorded.");
        } else {
            ((TextView) findViewById(R.id.displayTaskName)).setText(taskName);
        }

        String taskInterval = i.getStringExtra("INTERVAL");
        if(taskInterval == null) {
            ((TextView) findViewById(R.id.displayTaskInterval)).setText("No task interval recorded.");
        } else {
            ((TextView) findViewById(R.id.displayTaskInterval)).setText(taskInterval);
        }

        String taskTime = i.getStringExtra("TIME");
        if(taskTime == null) {
            ((TextView) findViewById(R.id.displayTaskTime)).setText("No task time recorded.");
        } else {
            ((TextView) findViewById(R.id.displayTaskTime)).setText(taskTime);
        }

        String taskDate = i.getStringExtra("DATE");
        if(taskDate == null) {
            ((TextView) findViewById(R.id.displayTaskDay)).setText("No task date recorded.");
        } else {
            ((TextView) findViewById(R.id.displayTaskDay)).setText(taskDate);
        }
    }
}