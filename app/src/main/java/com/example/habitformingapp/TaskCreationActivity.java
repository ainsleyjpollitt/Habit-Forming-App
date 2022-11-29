package com.example.habitformingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.view.View.OnKeyListener;
import android.view.View;
import android.view.KeyEvent;

import java.io.IOException;

public class TaskCreationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_creation);
        Spinner spinnerTaskInterval = findViewById(R.id.editTaskInterval);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.intervals, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerTaskInterval.setAdapter(adapter);
        /*
        findViewById(R.id.editTaskName).setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent keyevent) {
                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    enterNewTaskName(v);
                    return true;
                }
                return false;
            }
        });

         */
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void createNewTask(View v) throws IOException {
        String taskName = ((EditText)findViewById(R.id.editTaskName)).getText().toString();
        String taskDay = findViewById(R.id.enterTaskDay).toString();
        String taskInterval = findViewById(R.id.editTaskInterval).toString();
        String taskTime = findViewById(R.id.editTaskTime).toString();
        file.write(taskName, taskDay, taskTime, taskInterval, this);

        Intent i = new Intent(this, TasksActivity.class);
        startActivity(i);
    }

}