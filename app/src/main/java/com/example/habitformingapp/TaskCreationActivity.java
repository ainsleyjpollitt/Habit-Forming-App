package com.example.habitformingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskCreationActivity extends AppCompatActivity implements DatePickerFragment.DatePickerFragmentListener {
    Spinner spinnerTaskInterval;
    String day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_creation);
        spinnerTaskInterval = findViewById(R.id.editTaskInterval);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.intervals, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerTaskInterval.setAdapter(adapter);
    }

    public void showTimePickerDialog(View v) {

        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");

    }

    @Override
    public void onDateSet(DatePicker view, int inputYear, int inputMonth, int inputDay) {
        // Set the text of the date field to the value in the date
        day = String.valueOf(inputDay);
        month = String.valueOf(inputMonth);
        year = String.valueOf(inputYear);


    }

    /*
    public void onTimeSet(String time) {
        timeView.setText(time);
    }
    */

    /* Create a new task to add into storage and display on
       the Tasks Activity page.
    */
    public void createNewTask(View v) throws IOException {
        String taskName = ((EditText)findViewById(R.id.editTaskName)).getText().toString();
        String taskDay = day + "/" + month + "/" + year;
        String taskInterval = spinnerTaskInterval.getSelectedItem().toString();
        String taskTime = findViewById(R.id.editTaskTime).toString();
        ArrayList<String> taskList = file.getFiles();

        Pattern p = Pattern.compile("^[ A-Za-z]+$");
        Matcher m = p.matcher(taskName);
        boolean isValidTaskName = m.matches();

        if(taskList.contains(taskName)) { // make sure a duplicate task is not being created
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("Can't create task.");
            builder.setMessage("It looks like a task with the name \"" + taskName + "\" already exists. " +
                               "Try another task name.");
            builder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else if(!isValidTaskName) { // make sure that task name only contains letter and spaces
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("Can't create task.");
            builder.setMessage("It looks like you tried to create a task with an invalid name. " +
                    "Use only letters and spaces to create your task name.");
            builder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        } else { // entered task information is acceptable, proceed with creation
            file.write(taskName, taskDay, taskTime, taskInterval, this);

            Intent i = new Intent(this, TasksActivity.class);
            startActivity(i);
        }
    }



}