package com.example.mahafuz.ratemysinging;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class FireBaseUserAdapter extends RecyclerView.Adapter<FireBaseUserAdapter.MyviewHolder> {
    List<UserData> data;

    public FireBaseUserAdapter(List<UserData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.firebase_user_layout,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, final int position) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference reference = database.getReference().child(Const.USER);
        holder.name.setText(data.get(position).getName());
        holder.age.setText(String.valueOf(data.get(position).getAge()));
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.child(data.get(position).getId()).removeValue();

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView age;
        Button remove;

        public MyviewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textFName);
            age =  itemView.findViewById(R.id.ageFAge);
            remove = itemView.findViewById(R.id.removeButton);

        }
    }
}

