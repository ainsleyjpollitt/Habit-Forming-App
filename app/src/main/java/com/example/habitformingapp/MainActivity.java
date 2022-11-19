package com.example.habitformingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");
    }

    public void launchTasks(View v) {
        Intent i = new Intent(this, TasksActivity.class);
        startActivity(i);
    }

    public void launchCalendar(View v) {
        Intent i = new Intent(this, CalendarActivity.class);
        startActivity(i);
    }

    public void launchTaskCreation(View v) {
        Intent i = new Intent(this, TaskCreationActivity.class);
        startActivity(i);
    }

    public void launchTaskInfo(View v) {
        Intent i = new Intent(this, TaskInfoActivity.class);
        startActivity(i);
    }

    public void launchStats(View v) {
        Intent i = new Intent(this, StatisticsActivity.class);
        startActivity(i);
    }
}