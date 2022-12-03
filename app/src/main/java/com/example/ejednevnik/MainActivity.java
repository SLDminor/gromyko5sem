package com.example.ejednevnik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ejednevnik.room.ActiveDatabase;
import com.example.ejednevnik.room.DBClient;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    List<ActiveDatabase> list;
    Button btn2;
    ImageButton btn1, btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.home_spisokvt_btn);
        btn2 = findViewById(R.id.home_cr_btn);
        btn3 = findViewById(R.id.home_calendar_btn);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        new Thread(() -> {
            list = DBClient.getInstance(getApplicationContext()).getAppDatabase().activeDatabaseDAO().getAll();
            runOnUiThread(() -> {
                myAdapter = new MyAdapter(list, MainActivity.this);
                recyclerView.setAdapter(myAdapter);
            });
        }).start();
    }


    public void goSpisokVtActivity(View v){
        Intent intent = new Intent(this, Spisok_Activity.class);
        startActivity(intent);
    }

    public void goCalendarActivity(View v){
        Intent intent = new Intent(this, Calendar_Activity.class);
        startActivity(intent);
    }

    public void goDeloCreation(View v){
        Intent intent = new Intent(this, Delo_Creation.class);
        startActivity(intent);
    }

}