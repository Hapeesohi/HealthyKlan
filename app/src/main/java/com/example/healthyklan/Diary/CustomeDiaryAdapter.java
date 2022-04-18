package com.example.healthyklan.Diary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthyklan.R;

import java.util.ArrayList;

public class CustomeDiaryAdapter extends RecyclerView.Adapter<CustomeDiaryAdapter.MyViewHolder> {

    Context context;
    ArrayList<String> list;

    CustomeDiaryAdapter(Context context, ArrayList<String> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.diary_row,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.textViewId.setText(position);
        holder.textViewId.setText("+");
        holder.textViewNote.setText(String.valueOf(list.get(position)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewId, textViewNote;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewId = itemView.findViewById(R.id.textNoteId);
            textViewNote = itemView.findViewById(R.id.textViewNote);
        }
    }
}
