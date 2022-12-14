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
}