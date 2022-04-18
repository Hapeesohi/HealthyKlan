package com.example.healthyklan.nutrition;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.healthyklan.R;
import com.example.healthyklan.database.MealDataBaseHelper;


public class MyMealFragment extends Fragment {

    MealDataBaseHelper mealDataBaseHelper;
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_meal, container, false);

        //listView = view.findViewById(R.id.listView);
            populateList();
            return view;
    }

    private void populateList(){
//        try {
//            Toast.makeText(getContext(), "Displaying data", Toast.LENGTH_SHORT).show();
//            Cursor data = mealDataBaseHelper.getData();
//            if(data == null){
//                Toast.makeText(getContext(), "Nothing to show!", Toast.LENGTH_SHORT).show();
//            }else{
//                ArrayList<String> listData = new ArrayList<>();
//                while(data.moveToNext()){
//                    listData.add(data.getString(1));
//
//                }
//                ListAdapter adapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,listData);
//                listView.setAdapter(adapter);
//            }
//
//        }catch (NullPointerException e){
//            Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
//        }



    }
}