package ru.mirea.vetoshkin.mireaproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PersonArea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseUser user = (FirebaseUser) getIntent().getSerializableExtra("EXTRA_SESSION_ID");
        TextView id = findViewById(R.id.textViewProviderId);
        TextView uid = findViewById(R.id.textViewUID);
        TextView name = findViewById(R.id.textViewName);
        TextView email = findViewById(R.id.textViewEmail);
        for (UserInfo profile : user.getProviderData()) {
            id.setText(profile.getProviderId());
            uid.setText(profile.getUid());
            name.setText(profile.getDisplayName());
            email.setText(profile.getEmail());
        };
    }
    public void onOut(View view){
        finish();
    }
}