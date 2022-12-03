package com.example.habitformingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        ListView list = findViewById(R.id.currentTasks);
        ArrayAdapter<String> adapter;
        Intent i = getIntent();
        ArrayList<String> taskList;
        if(getIntent().getExtras() != null) { // if there hasn't been an intent call from Task Details
            taskList = i.getStringArrayListExtra("TASK LIST");
            changeListItemColor(i, taskList, list);
        } else {
            taskList = file.getFiles();
        }
        adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.activity_listview, taskList);

        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                launchTaskInfo(list, position);
            }
        });

    }

    /* Changes the color of an item in the task
       list based on if it was marked complete or
       incomplete.
    */
    public void changeListItemColor(Intent i, ArrayList<String> taskList, ListView list) {
        Bundle bundle = getIntent().getExtras();
        String file = i.getStringExtra("File name");
        boolean isChecked = bundle.getBoolean("Is Checked");
        for(int j = 0; j < taskList.size(); j++) {
            if(file.equals(taskList.get(j))) {
                View listItem = list.getChildAt(j);
                if(isChecked) {
                    listItem.setBackgroundColor(Color.GREEN);
                } else {
                    listItem.setBackgroundColor(Color.WHITE);
                }
            }
        }
    }

    /* Launch to the Task Details page to display
       the stored information on a task. Use the
       position in the list to determine which task's
       data should be displayed.
    */
    public void launchTaskInfo(View v, int position) {
        Intent i = new Intent(this, TaskInfoActivity.class);
        String taskName = null;
        String taskTime = null;
        String taskDate = null;
        String taskInterval = null;

        FileReader reader;
        StringBuilder word = new StringBuilder();
        int next = 0;
        File[] files = file.directory.listFiles();
        File currentTaskFile = null;
        if(files != null) {
            currentTaskFile = files[position];
        }

        try {
            reader = new FileReader(currentTaskFile);
            reader.read();
            while ((next = reader.read()) != -1) { // get name
                word.append((char) next);
            }

            String[] storedFileData = word.toString().split(",");

            taskName = storedFileData[0];
            taskInterval = storedFileData[storedFileData.length - 1];
            //taskTime = storedFileData[];
            //taskDate = storedFileData[];

        } catch (Exception e) {
            e.printStackTrace();
        }

        i.putExtra("NAME", taskName);
        i.putExtra("TIME", taskTime);
        i.putExtra("DATE", taskDate);
        i.putExtra("INTERVAL", taskInterval);
        ArrayList<String> taskList = file.getFiles();
        i.putStringArrayListExtra("TASK LIST", taskList);

        startActivity(i);
    }
}