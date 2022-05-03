package ru.mirea.vetoshkin.mireaproject.db;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.mirea.vetoshkin.mireaproject.R;

public class PersonListAdapter extends RecyclerView.Adapter<PersonListAdapter.MyViewHolder> {

    private Context context;
    private List<Person> personList;
    public PersonListAdapter(Context context) {
        this.context = context;
    }

    public void setUserList(List<Person> userList) {
        this.personList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PersonListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonListAdapter.MyViewHolder holder, int position) {
        holder.tvFirstName.setText(this.personList.get(position).firstName);
        holder.tvLastName.setText(this.personList.get(position).lastName);
    }

    @Override
    public int getItemCount() {
        return  this.personList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvFirstName;
        TextView tvLastName;

        public MyViewHolder(View view) {
            super(view);
            tvFirstName = view.findViewById(R.id.tvFirstName);
            tvLastName = view.findViewById(R.id.tvLastName);

        }
    }
}
