package ru.mirea.vetoshkin.resultactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {
    private EditText universityEditText;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        universityEditText = findViewById(R.id.universityEditText);
    }
    public void sendResultOnMainActivityOnClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("name", universityEditText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}