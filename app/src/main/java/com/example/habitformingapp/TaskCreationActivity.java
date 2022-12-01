package com.example.habitformingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.IOException;

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

    public void createNewTask(View v) throws IOException {
        String taskName = ((EditText)findViewById(R.id.editTaskName)).getText().toString();
        String taskDay = day + "/" + month + "/" + year;
        String taskInterval = spinnerTaskInterval.getSelectedItem().toString();
        String taskTime = findViewById(R.id.editTaskTime).toString();
        file.write(taskName, taskDay, taskTime, taskInterval, this);

        Intent i = new Intent(this, TasksActivity.class);
        startActivity(i);
    }



}