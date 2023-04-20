package com.example.moban;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLinearLayout;
    private CalendarView mCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the LinearLayout and CalendarView from the layout XML file
        mLinearLayout = findViewById(R.id.linear_layout);
        mCalendarView = findViewById(R.id.calendar_view);

        // Set the CalendarView to only show the current week
        mCalendarView.setShowWeekNumber(false);
        mCalendarView.setFirstDayOfWeek(Calendar.MONDAY);
        mCalendarView.setDate(System.currentTimeMillis());
        mCalendarView.setMaxDate(System.currentTimeMillis() + (7 * 24 * 60 * 60 * 1000) - 1);

        // Add the CalendarView to the LinearLayout
        mLinearLayout.addView(mCalendarView);
    }
}
