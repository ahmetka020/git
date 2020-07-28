package com.whoami.mobilprogramlama;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {
    Integer passwordCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText username = findViewById(R.id.Username);
        final EditText password = findViewById(R.id.Password);
        Button loginButton = findViewById(R.id.LoginButton);
        loginButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                passwordCount++;
                System.out.println(username.getText() + "---------------------------");
                if (checkPassword(username.getText(), password.getText())) {
                    Toast.makeText(MainActivity.this, "Şifre Doğru", Toast.LENGTH_SHORT).show();

                    Intent helloAndroidIntent = new Intent(MainActivity.this,MainMenuActivity.class);
                    helloAndroidIntent.putExtra("usernameK",username.getText().toString());
                    startActivity(helloAndroidIntent);
                }

                else {
                    Toast.makeText(MainActivity.this, "Şifre Yanlış, Kalan deneme : " + (3-passwordCount), Toast.LENGTH_SHORT).show();
                    username.setText("");
                    password.setText("");
                }
                if (passwordCount >= 3){
                    Toast.makeText(MainActivity.this, "Şifre Yanlış", Toast.LENGTH_SHORT).show();
                    finish();
                    System.exit(0);
                }
            }


        });

    }

    private boolean checkPassword(Editable uname, Editable password) {
        ArrayList<Person> p = new ArrayList<Person>();
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        p1.setID("admin");
        p1.setPassword("admin");
        p2.setID("admin1");
        p2.setPassword("admin1");
        p3.setID("admin2");
        p3.setPassword("admin2");
        p.add(p1);
        p.add(p2);
        p.add(p3);

        
        for(Person i: p){
            if (uname.toString().equals(i.getID()) && password.toString().equals(i.getPassword())) {
                return true;
            }
        }
        return false;
    }
}








