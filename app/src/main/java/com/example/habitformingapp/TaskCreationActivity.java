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

    public void createNewTask(View v) {
        Intent i = new Intent(this, TasksActivity.class);
        String taskName = ((EditText)v).getText().toString();
        i.putExtra("TASK_NAME", taskName);

        String taskInterval = ((SpinnerAdapter)v).toString();
        i.putExtra("TASK_INTERVAL", taskInterval);

        String taskDay = ((Button)v).getText().toString();
        i.putExtra("TASK_DAY", taskDay);

        String taskTime = ((Button)v).getText().toString();
        i.putExtra("TASK_TIME", taskTime);

        startActivity(i);
    }

}