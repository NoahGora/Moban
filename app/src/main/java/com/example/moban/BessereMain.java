package com.example.moban;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class BessereMain extends AppCompatActivity {

    EditText newTaskEditText;
    ImageView sendButton;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

        protected void initViews(){
            newTaskEditText = findViewById(R.id.new_task);
            sendButton = findViewById(R.id.send_button);


        }

        protected void initClickListener(){
            sendButton.setOnClickListener(view -> onSendButtonClick());
        }

        protected void onSendButtonClick(){
            String newTaskName = newTaskEditText.getText().toString();
            Log.d("Es funktioniert", "Neue Aufgabe: " + newTaskName);
        }
}
