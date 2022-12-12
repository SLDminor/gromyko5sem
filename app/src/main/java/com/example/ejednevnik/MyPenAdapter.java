package com.example.ejednevnik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Delete;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ejednevnik.room.DBClient;
import com.example.ejednevnik.room.PendingDatabase;

import java.util.List;

import kotlin.Function;

public class MyPenAdapter extends RecyclerView.Adapter<MyPenAdapter.ViewRow> {

    private List<PendingDatabase> list;
    private PendingDatabase zapis;
    private Context context;
    public MyPenAdapter(List<PendingDatabase> list, Context context) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.zapis_pending_del,parent,false);
        return new ViewRow(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewRow holder, @SuppressLint("RecyclerView") int position) {
        holder.textView1.setText(list.get(position).getName());
        holder.textView2.setText(list.get(position).getTime());
        holder.textView3.setText(list.get(position).getType());
        holder.del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(() -> {
                    int z_id = list.get(position).getId();
                    zapis = DBClient.getInstance(context.getApplicationContext()).getAppDatabase().pendingDatabaseDAO().getdelo(z_id);
                    DBClient.getInstance(context.getApplicationContext()).getAppDatabase().pendingDatabaseDAO().delete(zapis);
                }).start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewRow extends RecyclerView.ViewHolder {
        private Button del_btn;
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;

        public ViewRow(@NonNull View itemView) {
            super(itemView);
            del_btn = itemView.findViewById(R.id.del_btn);
            textView1 = itemView.findViewById(R.id.delo_name);
            textView2 = itemView.findViewById(R.id.pen_delo_time);
            textView3 = itemView.findViewById(R.id.pen_delo_type);
        }

    }
}