package com.example.habitformingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnKeyListener;
import android.view.View;
import android.view.KeyEvent;

public class TaskCreationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_creation);
        findViewById(R.id.editTaskName).setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent keyevent) {
                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    enterNewTaskName(v);
                    return true;
                }
                return false;
            }
        });
    }

    public void enterNewTaskName(View v) {
        Intent i = new Intent(this, TasksActivity.class);
        String taskName = ((EditText)v).getText().toString();
        i.putExtra("TASK_NAME", taskName);
        startActivity(i);
    }
}