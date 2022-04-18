package com.example.healthyklan.nutrition;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.healthyklan.R;
import com.example.healthyklan.VolleySingle;
import com.example.healthyklan.database.MealDataBaseHelper;
import com.example.healthyklan.modal.Meal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchMealFragment extends Fragment {

    EditText searchViewMeal;
    RecyclerView recyclerViewMeals;
    LinearLayoutManager layoutManager;
    MealSearchAdapter mealSearchAdapter;
    RelativeLayout progressLayout;
    ProgressBar progressBar;
    RequestQueue requestQueue;
    ImageView ivSearchButton;
    //public String mealTpe;
    ArrayList<Meal> meals = new ArrayList<Meal>();

    MealDataBaseHelper mDataBaseHelper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_meal, container, false);

        searchViewMeal = view.findViewById(R.id.etSearchBar);
        recyclerViewMeals = view.findViewById(R.id.recyclerViewMeals);
//        progressLayout = view.findViewById(R.id.progressLayout);
//        progressBar = view.findViewById(R.id.progresBar);
        ivSearchButton = view.findViewById(R.id.ivsearchbtn);
        mDataBaseHelper = new MealDataBaseHelper(getContext());

//        progressLayout.setVisibility(View.INVISIBLE);
//
        recyclerViewMeals.setLayoutManager(new LinearLayoutManager(getContext()));
        
        requestQueue = VolleySingle.getmInstance(getContext()).getRequestQueue();

        ivSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mealToSearch = searchViewMeal.getText().toString();
                mealToSearch = mealToSearch.replace(" ","");

                if(mealToSearch.isEmpty()){
                    //Toast.makeText(getContext(), "MEal type is "+mealTpe, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(), "No meal entered! Type proper name", Toast.LENGTH_LONG).show();
                }else{

                    fetchMeals(mealToSearch);
                }

            }
        });

        return view;
    }

    private void fetchMeals(String mealToSearch) {

        String url = "https://calorieninjas.p.rapidapi.com/v1/nutrition?query="+mealToSearch;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray jsonArray = response.getJSONArray("items");
                    for(int i=0;i<jsonArray.length();i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String name = jsonObject.getString("name");
                        Double fiber = jsonObject.getDouble("fiber_g");
                        Double servingSize = jsonObject.getDouble("serving_size_g");
                        Double fat = jsonObject.getDouble("fat_total_g");
                        Double calories = jsonObject.getDouble("calories");
                        Double protein = jsonObject.getDouble("protein_g");
                        Double carbs = jsonObject.getDouble("carbohydrates_total_g");

                        Meal meal = new Meal(name, fiber, fat, calories, protein, carbs, servingSize);
                        meals.add(meal);

//                        progressLayout.setVisibility(View.INVISIBLE);

                        Toast.makeText(getContext(), "Name :  " + name + " calories : " + calories.toString() + " carbs : " + carbs.toString(), Toast.LENGTH_SHORT).show();
                    }
                }catch(JSONException e){
                    e.printStackTrace();
                    Toast.makeText(getContext(), "Incomplete meal name!", Toast.LENGTH_SHORT).show();
                }
                 MealSearchAdapter adapter = new MealSearchAdapter(getContext(),meals);
                recyclerViewMeals.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage()+"", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap headerOne = new HashMap();
                headerOne.put("X-RapidAPI-Host","calorieninjas.p.rapidapi.com");
                headerOne.put("X-RapidAPI-Key","1ba4150b49msh1d7621a9c6c2c84p124348jsnb3069a90748a");

                return headerOne;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }




}