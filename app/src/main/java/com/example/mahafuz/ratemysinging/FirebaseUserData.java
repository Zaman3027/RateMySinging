package com.example.mahafuz.ratemysinging;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseUserData extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    List<UserData> data;
    DatabaseReference reference;
    FirebaseDatabase database;
    FireBaseUserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_user);

        recyclerView = findViewById(R.id.fireBaseRecycler);
        data = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child(Const.USER);


        floatingActionButton = findViewById(R.id.addUser);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirebaseUserData.this,AddUserRealTime.class));
            }
        });
        adapter = new FireBaseUserAdapter(data);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                data.clear();
                for (DataSnapshot child: dataSnapshot.getChildren()) {
                    //Log.e("Name 45",child.child("Name").getValue().toString());
                    //Log.d("New Id",child.getKey());
                    String id = child.getKey();
                    String name = child.child(Const.NAME).getValue().toString();
                    int age = Integer.parseInt(child.child(Const.AGE).getValue().toString());
                    data.add(new UserData(name,age,id));
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
}
