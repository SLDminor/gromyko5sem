package com.example.ejednevnik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ejednevnik.room.ActiveDatabase;
import com.example.ejednevnik.room.DBClient;

public class Calendar_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }

    public void goBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goSpisokVtActivity(View v){
        Intent intent = new Intent(this, Spisok_Activity.class);
        startActivity(intent);
    }

    public static class Delo_Creation extends AppCompatActivity {

        EditText ed1, ed2, ed3, ed4;
        Button btn;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_delo_creation);
            ed1 = findViewById(R.id.editPenDeloName);
            ed2 = findViewById(R.id.editPenDeloType);
            ed3 = findViewById(R.id.editDeloBTime);
            ed4 = findViewById(R.id.editPenDeloTime);
            btn = findViewById(R.id.delo_create_button);
            String name = ed1.getText().toString();
            String date = ed2.getText().toString();
            String b_time = ed3.getText().toString();
            String e_time = ed4.getText().toString();
            ActiveDatabase activeDatabase = new ActiveDatabase(name,date,b_time,e_time);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            DBClient.getInstance(getApplicationContext()).getAppDatabase().activeDatabaseDAO().insert(activeDatabase);
                        }
                    }).start();
                }
            });

        }


    }
}