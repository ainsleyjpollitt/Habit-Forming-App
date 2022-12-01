package com.example.habitformingapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {



    private DatePickerFragmentListener listener;

    public interface DatePickerFragmentListener {
        void onDateSet(DatePicker view, int inputYear, int inputMonth, int inputDay);
    }

    public static DatePickerFragment newInstance(DatePickerFragmentListener listener) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setDatePickerListener(listener);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(requireContext(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int inputYear, int inputMonth, int inputDay) {
        /*
        //Read the passed bundle from the activity
        Bundle setDate = this.getArguments();
        long currDate = 0;
        if(setDate != null) {
            currDate = setDate.getLong("setDate");
            String contents = setDate.toString();
            Log.i("Test tag", contents);
        } else {
            Log.i("Other test tag", "null");
        }

         */
        final Calendar c = Calendar.getInstance();
        //c.setTimeInMillis(currDate);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        c.set(inputYear, inputMonth, inputDay, 0, 0);
        Log.i("Test tag", c.toString());
        //Date formattedDate = c.getTime();
        notifyDatePickerListener(view, year, month, day);
    }

    public DatePickerFragmentListener getDatePickerListener() {
        return this.listener;
    }

    public void setDatePickerListener(DatePickerFragmentListener listener) {
        this.listener = listener;
    }

    protected void notifyDatePickerListener(DatePicker view, int inputYear, int inputMonth, int inputDay) {
        if(this.listener != null) {
            this.listener.onDateSet(view, inputYear, inputMonth, inputDay);
        }
    }


}