package com.example.moban;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.LinearLayout;

import android.os.Bundle;
import android.widget.CalendarView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hole eine Referenz auf den Kalender-View
        CalendarView calendarView = findViewById(R.id.calendarView);

        // Erstelle ein Calendar-Objekt und setze es auf die aktuelle Zeit
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        // Setze das aktuelle Datum als ausgewähltes Datum im Kalender
        calendarView.setDate(System.currentTimeMillis());

        // Setze das minimale Datum auf den Anfang der aktuellen Woche
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        long minDate = calendar.getTimeInMillis();
        calendarView.setMinDate(minDate);

        // Setze das maximale Datum auf das Ende der aktuellen Woche
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
        calendar.add(Calendar.DAY_OF_WEEK, -1);
        long maxDate = calendar.getTimeInMillis();
        calendarView.setMaxDate(maxDate);

        // Setze den Kalender-View in den Wochenmodus
        calendarView.setCalendarDisplayMode(CalendarMode.WEEK);

        // Setze das erste Wochentag auf den aktuellen Tag
        calendarView.setFirstDayOfWeek(calendar.getFirstDayOfWeek());

        // Reagiere auf Scroll-Ereignisse, um das maximale Datum zu aktualisieren
        calendarView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                // Wenn der Benutzer nach links scrollt, aktualisiere das maximale Datum des Kalenders
                if (scrollX < oldScrollX) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(calendarView.getMaxDate());
                    calendar.add(Calendar.DAY_OF_YEAR, 1);
                    calendarView.setMaxDate(calendar.getTimeInMillis());
                }
            }
        });
    }
}

