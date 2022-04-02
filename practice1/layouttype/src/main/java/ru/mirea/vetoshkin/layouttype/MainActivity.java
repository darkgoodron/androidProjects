package ru.mirea.vetoshkin.layouttype;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task1);
        TextView myTextView = (TextView) findViewById(R.id.textView5);
        myTextView.setText("Ashot");
        Button myButton = findViewById(R.id.button14);
        myButton.setText("Save contact");
        CheckBox myCheckBox = findViewById(R.id.checkBox2);
        myCheckBox.setChecked(true);
    }
}