package com.whoami.mobilprogramlama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPreferencesActivity extends AppCompatActivity {
    //Her bir kullanıcı için ayrı sharedPreferences.
    Button saveButton;
    EditText ageText;
    EditText heightText;
    EditText weightText;
    TextView usernameText;
    Switch genderSwitch;
    TextView genderTextView;


    String username = "DEFAULT";


    public static final String ageK = "ageKey";
    public static final String weightK = "weightKey";
    public static final String heightK = "heightKey";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        saveButton = findViewById(R.id.NoteSaveButton);
        ageText = findViewById(R.id.ageText);
        heightText = findViewById(R.id.heightText);
        weightText = findViewById(R.id.weightText);
        usernameText = findViewById(R.id.usernameText);
        usernameText.setEnabled(false);
        username = getIntent().getStringExtra("usernameK");
        usernameText.setText(username);
        genderSwitch = findViewById(R.id.GenderSwitch);
        genderTextView = findViewById(R.id.GenderTextView);


        sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        ageText.setText(sharedpreferences.getString(ageK,""));
        heightText.setText(sharedpreferences.getString(heightK,""));
        weightText.setText(sharedpreferences.getString(weightK,""));
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age = ageText.getText().toString();
                String weight = weightText.getText().toString();
                String height = heightText.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(ageK, age);
                editor.putString(weightK, weight);
                editor.putString(heightK, height);
                editor.commit();
                Toast.makeText(SharedPreferencesActivity.this, "Thanks", Toast.LENGTH_LONG).show();

            }

        });
        genderSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    genderTextView.setText("Female");
                }
                else{
                    genderTextView.setText("Male");
                }
            }
        });
    }
}
