package com.example.habitformingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
        ArrayList<String> taskList = file.getFiles();
        adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.activity_listview, taskList);

        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                launchTaskInfo(list, position);
            }
        });

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
            while ((next = reader.read()) != ',') { // get name
                word.append((char) next);
            }
            taskName = word.toString();
            //word = new StringBuilder();
            //word.append((char) next);

            /*
            while ((next = reader.read()) != ' ') { // get time
                word.append((char) next);
            }

            taskTime = word.toString();
            word = new StringBuilder();
            word.append((char) next);

            while ((next = reader.read()) != ' ') { // get date
                word.append((char) next);
            }

            taskDate = word.toString();
            word = new StringBuilder();
            word.append((char) next);

            while ((next = reader.read()) != ' ') { // get interval
                word.append((char) next);
            }

            taskInterval = word.toString();
            word = new StringBuilder();
            word.append((char) next);
           */
        } catch (Exception e) {
            e.printStackTrace();
        }

        i.putExtra("NAME", taskName);
        i.putExtra("TIME", taskTime);
        i.putExtra("DATE", taskDate);
        i.putExtra("INTERVAL", taskInterval);

        startActivity(i);
    }



    /*
    private static String getTaskDetail(FileReader reader, StringBuilder word, int next,
                                        String detail) {
        return detail;

    }

    */


}