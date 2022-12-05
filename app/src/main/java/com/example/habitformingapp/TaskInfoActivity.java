package com.example.habitformingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class TaskInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_info);
        Intent i = getIntent();
        displayTaskDetails(i);

        Switch toggle = (Switch) findViewById(R.id.toggleComplete);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) { // enabled
                    //toggleTask(i, isChecked);
                    toggle.setText("Task is complete.");
                } else { // disabled
                    //toggleTask(i, isChecked);
                    toggle.setText("Task is incomplete.");
                }
            }
        });
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

    /* Remove a task permanently from storage.
    */
    public void deleteTask(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Are you sure you want to delete this task?");
        builder.setMessage("Click confirm to proceed and permanently delete this task.");
        builder.setPositiveButton("Confirm",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        removeTaskFromStorage();
                    }
                });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /* Goes into storage to remove a task that
       has been selected by the user for deletion.
    */
    private void removeTaskFromStorage() {
        Log.i("Removing", "Gonna remove");
        Intent i = getIntent();
        String taskName = i.getStringExtra("NAME");
        if(taskName == null) {
            ((TextView) findViewById(R.id.displayTaskName)).setText("No task name recorded.");
        } else {
            ((TextView) findViewById(R.id.displayTaskName)).setText(taskName);
        }
        ArrayList<String> taskList = file.getFiles();
        if(taskList.contains(taskName)) {
            file.deleteFile(taskName);
        }
        Log.i("Finished", "At end of removal");
    }

    /* Changed the saved details about
       a task in storage.
    */
    public void editTask(View v) {

    }

    /* Set up the color of the list item on the Task page
       to change when a task is marked complete or
       incomplete.
    */
    public void toggleTask(Intent i, boolean isChecked) {
        String taskName = i.getStringExtra("NAME");
        ArrayList<String> taskList = i.getStringArrayListExtra("TASK LIST");
        Intent intent = new Intent(this, TasksActivity.class);
        intent.putExtra("Task file", taskName);
        intent.putExtra("Is Checked", isChecked);
        intent.putStringArrayListExtra("TASK LIST", taskList);
        //startActivity(intent);
    }


}