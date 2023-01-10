package ru.mirea.vetoshkin.mireaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.mirea.vetoshkin.mireaproject.db.AddNewPersonActivity;
import ru.mirea.vetoshkin.mireaproject.db.AppDatabase;
import ru.mirea.vetoshkin.mireaproject.db.Person;
import ru.mirea.vetoshkin.mireaproject.db.PersonListAdapter;

public class Room extends Fragment {

    private PersonListAdapter personListAdapter;
    private View inflaterView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflaterView = inflater.inflate(R.layout.fragment_room, container, false);

//        Button addNewUserButton = inflaterView.findViewById(R.id.addNewUserButton);
        inflaterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getActivity(), AddNewPersonActivity.class), 100);
            }
        });

        initRecyclerView();

        loadUserList();
        return inflaterView;
    }
    private void initRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) inflaterView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        personListAdapter = new PersonListAdapter(getActivity());
        recyclerView.setAdapter(personListAdapter);
    }

    private void loadUserList() {
        AppDatabase db = AppDatabase.getDbInstance(requireActivity().getApplicationContext());
        List<Person> personList = db.userDao().getAllUsers();
        personListAdapter.setUserList(personList);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100) {
            loadUserList();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}