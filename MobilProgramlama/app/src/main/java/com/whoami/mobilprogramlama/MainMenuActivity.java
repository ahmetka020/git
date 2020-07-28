package com.whoami.mobilprogramlama;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {

    Button emailButton;
    Button settingsButton;
    Button sensorButton;
    Button usersButton;
    Button noteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        final String username = intent.getStringExtra("usernameK");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        emailButton = findViewById(R.id.EmailButton);
        settingsButton = findViewById(R.id.SettingsButton);
        sensorButton = findViewById(R.id.SensorButton);
        usersButton = findViewById(R.id.UsersButton);
        noteButton = findViewById(R.id.NoteButton);

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsIntent = new Intent(MainMenuActivity.this,SharedPreferencesActivity.class);
                settingsIntent.putExtra("usernameK",username);
                startActivity(settingsIntent);
            }

        });

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(MainMenuActivity.this,MailActivity.class);
                startActivity(emailIntent);
            }

        });

        usersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent usersIntent = new Intent(MainMenuActivity.this,UsersActivity.class);
                startActivity(usersIntent);
            }

        });
        noteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noteIntent = new Intent(MainMenuActivity.this,NoteActivity.class);
                startActivity(noteIntent);
            }

        });
        sensorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sensorIntent = new Intent(MainMenuActivity.this,SensorActivity.class);
                startActivity(sensorIntent);
            }

        });
    }
}
