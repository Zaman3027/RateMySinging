package com.example.mahafuz.ratemysinging;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class AddUserRealTime extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    TextView name,age;
    Button submit;
    TextInputLayout inName,inAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_real_time);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference().child("User");

        name = findViewById(R.id.nameText);
        age = findViewById(R.id.ageText);
        submit = findViewById(R.id.submit);
        inName = findViewById(R.id.nameInputLayout);
        inAge = findViewById(R.id.ageInputLayout);

        final Map<String,String> data = new HashMap<>();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //data.put(name.getText().toString(),age.getText().toString());
                if(verify(name.getText().toString(),age.getText().toString())){
                    data.put("Name",name.getText().toString());
                    data.put("age",age.getText().toString());
                    reference.push().setValue(data);
                }

                startActivity(new Intent(AddUserRealTime.this,FirebaseUserData.class));
            }
        });









    }
    boolean verify(String name, String age){
        if (name.isEmpty()||age.isEmpty()){
            if (age.isEmpty()){
                inAge.setError("Field Cannot empty");
            }
            if (name.isEmpty()){
                inName.setError("Field cannot be empty");
            }

            return false;
        }

        return true;
    }

}
