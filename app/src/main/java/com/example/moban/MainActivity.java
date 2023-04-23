package com.example.moban;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    private String[] weekDays = {"Mo", "Di", "Mi", "Do", "Fr", "Sa", "So"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableLayout = findViewById(R.id.tableLayout);

        // Add current date
        TextView currentDateView = findViewById(R.id.currentDate);
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        currentDateView.setText(dateFormat.format(Calendar.getInstance().getTime()));

        // Die Tabelle erstellen
        TableLayout tableLayout = findViewById(R.id.tableLayout);

// Die erste Zeile der Tabelle erstellen (Wochentage)
        TableRow headerRow = new TableRow(this);
        headerRow.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        String[] weekdays = {"Mo", "Di", "Mi", "Do", "Fr", "Sa", "So"};

        for (String weekday : weekdays) {
            TextView headerText = new TextView(this);
            headerText.setText(weekday);
            headerText.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            headerText.setGravity(Gravity.CENTER);
            headerText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            headerRow.addView(headerText);
        }

        tableLayout.addView(headerRow);

// Die zweite Zeile der Tabelle erstellen (Tag)
        TableRow dayRow = new TableRow(this);
        dayRow.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < weekdays.length; i++) {
            TextView dayText = new TextView(this);

            // Das Datum für den jeweiligen Wochentag erhalten
            calendar.set(Calendar.DAY_OF_WEEK, i + 2);
            dayText.setText(String.format(Locale.getDefault(), "%02d", calendar.get(Calendar.DAY_OF_MONTH)));

            dayText.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            dayText.setGravity(Gravity.CENTER);
            dayText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            dayText.setTag(calendar.getTimeInMillis()); // Das Datum als Tag speichern
            int finalI = i;
            dayText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Snackbar anzeigen, wenn die Zelle geklickt wird
                    Calendar clickedCalendar = Calendar.getInstance();
                    clickedCalendar.setTimeInMillis((long) v.getTag());
                    String message = weekdays[finalI] + ", " + clickedCalendar.get(Calendar.DAY_OF_MONTH);
                    Snackbar.make(tableLayout, message, Snackbar.LENGTH_SHORT).show();
                }
            });
            dayRow.addView(dayText);
        }

        tableLayout.addView(dayRow);
    }
}
