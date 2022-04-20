package ru.mirea.vetoshkin.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private String fileName;
    private String text;
    private EditText et1;
    private EditText et2;
    private SharedPreferences preferences;
    final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.editTextTextMultiLine);
        et2 = findViewById(R.id.editTextTextMultiLine2);
        preferences = getPreferences(MODE_PRIVATE);

        fileName = preferences.getString(SAVED_TEXT, "Empty");
        if(!fileName.equals("")){
            et1.setText(fileName);
            et2.setText(getTextFromFile());
        }
    }
    public String getTextFromFile() {
        FileInputStream fin = null;
        try {
            fin = openFileInput(fileName);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            Log.d(LOG_TAG, text);
            return text;
        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        return null;
    }
    public void saveFileName(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(SAVED_TEXT, et1.getText().toString());
        editor.apply();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }
    public void makeFile(){
        setContentView(R.layout.activity_main);
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(text.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void onSaveData(View view){
        fileName = et1.getText().toString();
        text = et2.getText().toString();
        saveFileName();
        String textFromFile = getTextFromFile();
        if(textFromFile == null){
            makeFile();
        }
    }
}