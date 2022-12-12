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

import com.example.ejednevnik.room.DBClient;
import com.example.ejednevnik.room.PendingDatabase;

public class Pending_Delo_Creation extends AppCompatActivity {
    EditText ed1;
    EditText ed2;
    EditText ed3;
    Button btn;

    public Pending_Delo_Creation() {
    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_delo_creation);
        this.ed1 = (EditText)this.findViewById(R.id.editPenDeloName);
        this.ed2 = (EditText)this.findViewById(R.id.editPenDeloType);
        this.ed3 = (EditText)this.findViewById(R.id.editPenDeloTime);
        this.btn = (Button)this.findViewById(R.id.delo_create_button);
        this.btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                (new Thread(new Runnable() {
                    public void run() {
                        final PendingDatabase pendingDatabase = new PendingDatabase(ed1.getText().toString(), ed2.getText().toString(), ed3.getText().toString());
                        DBClient.getInstance(Pending_Delo_Creation.this.getApplicationContext()).getAppDatabase().pendingDatabaseDAO().insert(pendingDatabase);
                        CreateDeloBack();
                    }
                })).start();
            }
        });
    }

    public void CreateDeloBack(){
        Intent intent = new Intent(this, Spisok_Activity.class);
        startActivity(intent);
    }
}

