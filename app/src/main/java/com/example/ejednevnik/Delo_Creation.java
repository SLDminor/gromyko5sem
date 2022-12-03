//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ejednevnik;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ejednevnik.room.ActiveDatabase;
import com.example.ejednevnik.room.DBClient;

public class Delo_Creation extends AppCompatActivity {
    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    Button btn;

    public Delo_Creation() {
    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_delo_creation);
        this.ed1 = (EditText)this.findViewById(R.id.editDeloName);
        this.ed2 = (EditText)this.findViewById(R.id.editDeloDate);
        this.ed3 = (EditText)this.findViewById(R.id.editDeloBTime);
        this.ed4 = (EditText)this.findViewById(R.id.editDeloETime);
        this.btn = (Button)this.findViewById(R.id.delo_create_button);
        this.btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                (new Thread(new Runnable() {
                    public void run() {
                        final ActiveDatabase activeDatabase = new ActiveDatabase(ed1.getText().toString(), ed2.getText().toString(), ed3.getText().toString(), ed4.getText().toString());
                        DBClient.getInstance(Delo_Creation.this.getApplicationContext()).getAppDatabase().activeDatabaseDAO().insert(activeDatabase);
                        CreateDeloBack();
                    }
                })).start();
            }
        });
    }

    public void CreateDeloBack(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

