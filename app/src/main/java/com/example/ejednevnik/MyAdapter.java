package com.example.ejednevnik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ejednevnik.room.ActiveDatabase;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewRow> {

    private List<ActiveDatabase> list;
    private Context context;

    public MyAdapter(List<ActiveDatabase> list, Context context) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.spisok_active_del,parent,false);
        return new ViewRow(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewRow holder, int position) {
        holder.textView1.setText(list.get(position).getName());
        holder.textView2.setText(list.get(position).getDate());
        holder.textView3.setText(list.get(position).getB_time());
        holder.textView4.setText(list.get(position).getE_time());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Что вы хотите сделать?")
                        .setCancelable(true)
                        .setPositiveButton("Редактировать дело", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

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
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private TextView textView4;

        public ViewRow(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.delo_name);
            textView2 = itemView.findViewById(R.id.delo_date);
            textView3 = itemView.findViewById(R.id.time_of_b);
            textView4 = itemView.findViewById(R.id.time_of_e);
        }

    }
}