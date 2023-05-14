package com.example.moban;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class BesteMain<val> extends AppCompatActivity {

    EditText newTaskEditText;
    ImageView sendButton;

    TaskManager taskManager;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskManager = new TaskManager();
        initViews();
        initClickListeners();
    }

        protected void initViews(){
            newTaskEditText = findViewById(R.id.new_task);
            sendButton = findViewById(R.id.send_button);
        }

        protected void initClickListeners(){
            sendButton.setOnClickListener(view -> onSendButtonClick());
        }

        protected void onSendButtonClick(){
            String newTaskName = newTaskEditText.getText().toString();
            if(newTaskName.length() > 3) {
                Task task = new Task();
                task.setName(newTaskName);
                taskManager.addTask(task);
                newTaskEditText.getText().clear();
                Log.d("Es funktioniert", "Neue Aufgabe: " + newTaskName);
            }else{
                Log.d("Checkliste", "Enter Text please");
            }
        }
}
