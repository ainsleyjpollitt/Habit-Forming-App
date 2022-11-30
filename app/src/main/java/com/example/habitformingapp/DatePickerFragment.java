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
        void onDatePicked(Date date);
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

    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, day, 0, 0);
        Date formattedDate = c.getTime();
        notifyDatePickerListener(formattedDate);
    }

    public DatePickerFragmentListener getDatePickerListener() {
        return this.listener;
    }

    public void setDatePickerListener(DatePickerFragmentListener listener) {
        this.listener = listener;
    }

    protected void notifyDatePickerListener(Date date) {
        if(this.listener != null) {
            this.listener.onDatePicked(date);
        }
    }


}