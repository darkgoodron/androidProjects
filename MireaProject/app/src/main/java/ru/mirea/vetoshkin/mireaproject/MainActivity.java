package ru.mirea.vetoshkin.mireaproject;

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
    public void onClickCalculator(View view) {
        calculator calc = new calculator();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, calc);
        ft.commit();
    }
    public void onClickPlayer(View view) {
        Player player = new Player();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, player);
        ft.commit();
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
    public void onClickGmap(View view) {
        MapsFragment fragment = new MapsFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }
}