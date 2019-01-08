package com.example.mahafuz.ratemysinging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button button;
    List<UserData> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();

        data.add(new UserData("Beata Mascio",20));
        data.add(new UserData("Monty Solis",21));
        data.add(new UserData("Floretta Burts",35));
        data.add(new UserData("Whitley Willsey",30));
        data.add(new UserData("Abraham Kreitzer",28));
        data.add(new UserData("Jasmin Seaton",23));
        data.add(new UserData("Jeanne Lofton",21));
        data.add(new UserData("Mickey Corey",31));
        data.add(new UserData("Lavonia Scola",26));
        data.add(new UserData("Brigid Daniell",27));

        recyclerView =  findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new UserAdapter(data));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        button = findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FirebaseUserData.class));
            }
        });
    }
}
