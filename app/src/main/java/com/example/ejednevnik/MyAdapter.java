package com.example.ejednevnik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewRow> {

    private ArrayList<MainActivity.ActiveDelo> arrayList;

    public MyAdapter(ArrayList<MainActivity.ActiveDelo> arrayList) {
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public ViewRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.spisok_active_del,parent,false);
        return new ViewRow(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewRow holder, int position) {
        holder.textView1.setText(arrayList.get(position).getName());
        holder.textView2.setText(arrayList.get(position).getName());
        holder.textView3.setText(arrayList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewRow extends RecyclerView.ViewHolder {
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;

        public ViewRow(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.delo_name);
            textView2 = itemView.findViewById(R.id.delo_date);
            textView3 = itemView.findViewById(R.id.delo_time);

        }

    }
}