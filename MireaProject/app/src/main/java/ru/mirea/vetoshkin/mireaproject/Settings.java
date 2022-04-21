package ru.mirea.vetoshkin.mireaproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Settings extends Fragment {

    private EditText field_nickname;
    private EditText field_hobby;
    private EditText field_city;
    private SharedPreferences preferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_settings, container, false);
        field_nickname = inflatedView.findViewById(R.id.editTextTextMultiLine);
        field_hobby = inflatedView.findViewById(R.id.editTextTextMultiLine2);
        field_city = inflatedView.findViewById(R.id.editTextTextMultiLine3);
        preferences = getActivity().getPreferences(Context.MODE_PRIVATE);

        Button button = (Button) inflatedView.findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v)
            {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(field_nickname.getText().toString(), String.join("/", field_nickname.getText(), field_hobby.getText(), field_city.getText()));
                editor.apply();
                Toast.makeText(getActivity(), "Text saved", Toast.LENGTH_SHORT).show();
            }
        });
        return inflatedView;
    }
}