package com.example.habitformingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,READ_EXTERNAL_STORAGE}, 1);
        }
        file.directory = new File(this.getFilesDir(), "stuff");
        if(!file.directory.exists()){
            file.directory.mkdir();
        }
        FileReader reader;
        String word = "";
        int next;
        for (File i : file.directory.listFiles()) {
            try {
                reader = new FileReader(i);
                reader.read();
                while ((next = reader.read()) != ' ') {
                    word+=(char)next;
                }
                file.files.add(word);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

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