package ru.mirea.vetoshkin.mireaproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<User> users;

    UserAdapter(Context context, List<User> users) {
        this.users = users;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        User user = users.get(position);
        holder.nickNameView.setText(user.getNickName());
        holder.hobbyView.setText(user.getHobby());
        holder.cityView.setText(user.getCity());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nickNameView, hobbyView, cityView;
        ViewHolder(View view){
            super(view);
            nickNameView = view.findViewById(R.id.nickName);
            hobbyView = view.findViewById(R.id.hobby);
            cityView = view.findViewById(R.id.city);
        }
    }
}
