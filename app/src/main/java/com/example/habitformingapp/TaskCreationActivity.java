package com.example.habitformingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.view.View.OnKeyListener;
import android.view.View;
import android.view.KeyEvent;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.IOException;
import java.util.Date;

public class TaskCreationActivity extends AppCompatActivity implements DatePickerFragment.DatePickerFragmentListener {
    TextView dateView, timeView;
    Spinner spinnerTaskInterval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_creation);
        spinnerTaskInterval = findViewById(R.id.editTaskInterval);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.intervals, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerTaskInterval.setAdapter(adapter);

        dateView = (TextView) findViewById(R.id.editTaskDay);
        timeView = (TextView) findViewById(R.id.editTaskTime);
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
    public void onDatePicked(Date date) {
        DatePickerFragment fragment = DatePickerFragment.newInstance(this);
        //fragment.getDatePickerListener();
        dateView.setText(date.toString());
    }

    public void onTimeSet(String time) {
        timeView.setText(time);
    }

    public void createNewTask(View v) throws IOException {
        String taskName = ((EditText)findViewById(R.id.editTaskName)).getText().toString();


        String taskDay = dateView.toString();

        String taskInterval = spinnerTaskInterval.getSelectedItem().toString();
        String taskTime = findViewById(R.id.editTaskTime).toString();
        file.write(taskName, taskDay, taskTime, taskInterval, this);

        Intent i = new Intent(this, TasksActivity.class);
        startActivity(i);
    }


}