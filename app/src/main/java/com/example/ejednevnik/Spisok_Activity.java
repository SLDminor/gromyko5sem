package com.example.ejednevnik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ejednevnik.room.ActiveDatabase;
import com.example.ejednevnik.room.DBClient;
import com.example.ejednevnik.room.PendingDatabase;

import java.util.List;

public class Spisok_Activity extends AppCompatActivity {

    private MyPenAdapter myPenAdapter;
    List<PendingDatabase> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spisok);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewPen);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        new Thread(() -> {
            list = DBClient.getInstance(getApplicationContext()).getAppDatabase().pendingDatabaseDAO().getAll();
            runOnUiThread(() -> {
                myPenAdapter = new MyPenAdapter(list, Spisok_Activity.this);
                recyclerView.setAdapter(myPenAdapter);
            });
        }).start();
    }

    public void goBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goCalendarActivity(View v){
        Intent intent = new Intent(this, Calendar_Activity.class);
        startActivity(intent);
    }

    public void goPenDeloCreation(View v){
        Intent intent = new Intent(this, Pending_Delo_Creation.class);
        startActivity(intent);
    }
}