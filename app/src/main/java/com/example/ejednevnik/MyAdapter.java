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

import com.example.ejednevnik.room.ActiveDatabase;
import com.example.ejednevnik.room.DBClient;

import java.util.List;

import kotlin.Function;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewRow> {

    private List<ActiveDatabase> list;
    private ActiveDatabase zapis;
    private Context context;
    public MyAdapter(List<ActiveDatabase> list, Context context) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.zapis_active_del,parent,false);
        return new ViewRow(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewRow holder, @SuppressLint("RecyclerView") int position) {
        holder.textView1.setText(list.get(position).getName());
        holder.textView2.setText(list.get(position).getDate());
        holder.textView3.setText(list.get(position).getB_time());
        holder.textView4.setText(list.get(position).getE_time());
        holder.del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(() -> {
                    int z_id = list.get(position).getId();
                    zapis = DBClient.getInstance(context.getApplicationContext()).getAppDatabase().activeDatabaseDAO().getdelo(z_id);
                    DBClient.getInstance(context.getApplicationContext()).getAppDatabase().activeDatabaseDAO().delete(zapis);
                }).start();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Что вы хотите сделать?")
                        .setCancelable(true)
                        .setPositiveButton("Редактировать дело", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int z_id = list.get(position).getId();
                                zapis = DBClient.getInstance(context.getApplicationContext()).getAppDatabase().activeDatabaseDAO().getdelo(z_id);
                                Intent intent = new Intent(context, Delo_Creation.class);
                                context.startActivity(intent);
                            }
                        })

                        .setNegativeButton("Удалить дело", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
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
        private TextView textView4;

        public ViewRow(@NonNull View itemView) {
            super(itemView);
            del_btn = itemView.findViewById(R.id.del_btn);
            textView1 = itemView.findViewById(R.id.delo_name);
            textView2 = itemView.findViewById(R.id.delo_date);
            textView3 = itemView.findViewById(R.id.time_of_b);
            textView4 = itemView.findViewById(R.id.time_of_e);
        }

    }
}