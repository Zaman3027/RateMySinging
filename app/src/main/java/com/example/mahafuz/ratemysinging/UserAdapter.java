package com.example.mahafuz.ratemysinging;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyviewHolder> {
    List<UserData> data;

    public UserAdapter(List<UserData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_layout,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.age.setText(String.valueOf(data.get(position).getAge()));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView age;

        public MyviewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textName);
            age =  itemView.findViewById(R.id.textAge);
        }
    }
}

