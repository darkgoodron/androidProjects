package ru.mirea.vetoshkin.mireaproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class History extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<User> users = new ArrayList<>();
        SharedPreferences preferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        Log.println(0, String.valueOf(12), "Size " + users.size());
        Map<String, ?> allEntries = preferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            String[] data = entry.getValue().toString().split("/");
            users.add(new User (data[0],  data[1], data[2]));
        }
        View inflatedView = inflater.inflate(R.layout.fragment_history, container, false);
        RecyclerView recyclerView = inflatedView.findViewById(R.id.result);
        UserAdapter adapter = new UserAdapter(getActivity(), users);
        recyclerView.setAdapter(adapter);
        return inflatedView;
    }
}
