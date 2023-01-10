package ru.mirea.vetoshkin.mireaproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Map;

public class History extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<User> users = new ArrayList<>();
        SharedPreferences preferences = this.requireActivity().getPreferences(Context.MODE_PRIVATE);
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
