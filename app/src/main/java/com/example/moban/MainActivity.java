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
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String[] WEEKDAYS = {"Mo", "Di", "Mi", "Do", "Fr", "Sa", "So"};
    private static final int NUM_ROWS = 2;
    private static final int NUM_COLS = 7;
    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableLayout = findViewById(R.id.table_layout);
        createTable();
    }

    private void createTable() {
        // Add header row
        TableRow headerRow = new TableRow(this);
        for (int j = 0; j < NUM_COLS; j++) {
            TextView cell = new TextView(this);
            cell.setText(WEEKDAYS[j]);
            cell.setGravity(Gravity.CENTER);
            headerRow.addView(cell);
        }
        tableLayout.addView(headerRow);

        // Add date row
        TableRow dateRow = new TableRow(this);
        Calendar calendar = Calendar.getInstance();
        for (int j = 0; j < NUM_COLS; j++) {
            TextView cell = new TextView(this);
            cell.setText(String.format(Locale.GERMAN, "%d", calendar.get(Calendar.DAY_OF_MONTH)));
            cell.setGravity(Gravity.CENTER);
            dateRow.addView(cell);
            calendar.add(Calendar.DATE, 1);
        }
        tableLayout.addView(dateRow);

        // Set click listeners for each cell
        for (int i = 0; i < NUM_ROWS; i++) {
            TableRow row = (TableRow) tableLayout.getChildAt(i);
            for (int j = 0; j < NUM_COLS; j++) {
                final TextView cell = (TextView) row.getChildAt(j);
                final String weekday = WEEKDAYS[j];
                final String date = cell.getText().toString();
                cell.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String message = String.format("%s, %s %d", weekday,
                                DateFormatSymbols.getInstance(Locale.GERMAN).getMonths()[Calendar.getInstance().get(Calendar.MONTH)],
                                Integer.parseInt(date));
                        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }
}

