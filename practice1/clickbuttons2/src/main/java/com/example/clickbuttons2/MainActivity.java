package com.example.clickbuttons2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvOut = (TextView) findViewById(R.id.tvOut);
        Button buttonOk = findViewById(R.id.button1);
        Button buttonCancel = findViewById(R.id.button2);
        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                tvOut.setText("OK button pressed");
            }
        };
        View.OnClickListener oclBtnCancel = new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                tvOut.setText("CANCEL button pressed");
            }
        };
        buttonOk.setOnClickListener(oclBtnOk);
        buttonCancel.setOnClickListener(oclBtnCancel);
    }
}