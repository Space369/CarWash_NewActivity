package com.example.carwash_newactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView display_MessageTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        display_MessageTV = findViewById(R.id.display_message);

        String message = getIntent().getStringExtra("message");
        display_MessageTV.setText(message);
    }
}
