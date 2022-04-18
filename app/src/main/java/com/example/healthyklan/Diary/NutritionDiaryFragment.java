package com.example.healthyklan.Diary;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthyklan.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class NutritionDiaryFragment extends Fragment {

    RecyclerView nutritionRecycler;
    CustomeDiaryAdapter customeDiaryAdapter;
    FloatingActionButton fabAddNutri;
    ArrayList<String> nutritionNotes = new ArrayList<>();
    String note;
    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nutrition_diary, container, false);

        nutritionRecycler = view.findViewById(R.id.recyclerViewDiaryNutrition);
        fabAddNutri = view.findViewById(R.id.nutriDiaryAdd);

        fabAddNutri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                alertDialog.setTitle("NOTE");

                final EditText input = new EditText(view.getContext());
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);
                alertDialog.setIcon(R.drawable.ic_add);
                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                note = input.getText().toString();
                                if (note == null || note.trim().equals("")) {
                                    Toast.makeText(getContext(), "Note is empty", Toast.LENGTH_SHORT).show();
                                } else {
                                    nutritionNotes.add(note);
                                    customeDiaryAdapter = new CustomeDiaryAdapter(view.getContext(), nutritionNotes);
                                    nutritionRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
                                    nutritionRecycler.setAdapter(customeDiaryAdapter);
                                    Toast.makeText(getContext(), "Done and note is " + note + " zereo place is " + nutritionNotes.get(0), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                alertDialog.show();
            }
        });

        return view;
    }
}