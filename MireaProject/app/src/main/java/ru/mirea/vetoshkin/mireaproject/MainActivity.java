package ru.mirea.vetoshkin.mireaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickPlayMusic(View view) {
        startService(
                new Intent(MainActivity.this, PlayerService.class));
    }
    public void onClickStopMusic(View view) {
        stopService(
                new Intent(MainActivity.this, PlayerService.class));
    }
    public void onClickHardware(View view) {
        Hardware fragment = new Hardware();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }
    public void onClickSettings(View view) {
        Settings fragment = new Settings();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }
    public void onClickHistory(View view) {
        History fragment = new History();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }
    public void onClickFireBase(View view) {
        Firebase fragment = new Firebase();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }
    public void onClickRoom(View view) {
        Room fragment = new Room();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }
}