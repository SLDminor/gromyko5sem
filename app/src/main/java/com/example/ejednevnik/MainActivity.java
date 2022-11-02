package com.example.ejednevnik;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    class ActiveDelo {
        private String name;
        private String date;
        private String time;

        public ActiveDelo(String name, String date, String time) {
            this.name = name;
            this.date = date;
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public String getDate() {
            return date;
        }

        public String getTime() {
            return time;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    private final String dela_name[] = {
            "Первое",
            "Второе",
            "Третье",
            "Четвёртое",
            "Пятое",
            "Шестое"
    };

    private final String dela_date[] = {
            "02.11.2022",
            "03.11.2022",
            "04.11.2022",
            "05.11.2022",
            "06.11.2022",
            "07.11.2022"
    };

    private final String dela_time[] = {
            "11:00",
            "12:00",
            "13:00",
            "14:00",
            "15:00",
            "16:00"
    };


    public ArrayList<ActiveDelo> genData() {
        ArrayList<ActiveDelo> list = new ArrayList<>();
        for(int i=0;i<dela_name.length;i++) {
            list.add(new ActiveDelo(dela_name[i],dela_date[i],dela_time[i]));
        }
        return list;
    }

    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new MyAdapter(genData());
        recyclerView.setAdapter(myAdapter);
    }

    public void showAddButtonChoose(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        AlertDialog.Builder builder1 = builder.setTitle("Что вы хотите сделать?")
                .setCancelable(true)
                .setPositiveButton("Создать дело", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })

                .setNegativeButton("Редактировать дело", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void goSpisokVtActivity(View v){
        Intent intent = new Intent(this, Spisok_Activity.class);
        startActivity(intent);
    }

    public void goCalendarActivity(View v){
        Intent intent = new Intent(this, Calendar_Activity.class);
        startActivity(intent);
    }

}