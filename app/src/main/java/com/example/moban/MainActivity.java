package com.example.moban;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.moban.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private CalendarView mCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Finde das Kalender-View-Element in unserem Layout
        mCalendarView = findViewById(R.id.calendarView);

        // Setze das Datum des Kalenders auf den heutigen Tag
        mCalendarView.setDate(Calendar.getInstance().getTimeInMillis());

        // Deaktiviere die Möglichkeit, Tage in der Vergangenheit auszuwählen
        mCalendarView.setMinDate(System.currentTimeMillis() - 1000);

        // Deaktiviere die Möglichkeit, Tage in der Zukunft auszuwählen
        Calendar maxCal = Calendar.getInstance();
        maxCal.set(Calendar.MONTH, maxCal.get(Calendar.MONTH) + 1);
        maxCal.set(Calendar.DAY_OF_MONTH, 1);
        mCalendarView.setMaxDate(maxCal.getTimeInMillis() - 1000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}