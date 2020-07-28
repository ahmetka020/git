package com.whoami.mobilprogramlama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class UsersActivity extends AppCompatActivity {
    RecyclerView usersRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        usersRecyclerView = findViewById(R.id.UsersRecyclerView);

        PersonAdapter productAdapter = new PersonAdapter(this, Person.getData());
        usersRecyclerView.setAdapter(productAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        usersRecyclerView.setLayoutManager(linearLayoutManager);

    }
}
