package com.example.habitformingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        ListView list = findViewById(R.id.currentTasks);
        ArrayAdapter<String> adapter;
        ArrayList<String> taskList = file.getFiles();
        adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.activity_listview, taskList);

        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                launchTaskInfo(list);
            }
        });

    }

    public void launchTaskInfo(View v) {
        Intent i = new Intent(this, TaskInfoActivity.class);
        startActivity(i);
    }

}