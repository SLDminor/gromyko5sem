package com.example.ejednevnik;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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