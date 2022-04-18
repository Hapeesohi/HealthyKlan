package com.example.healthyklan.nutrition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthyklan.R;
import com.example.healthyklan.database.MealDataBaseHelper;
import com.example.healthyklan.modal.Meal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MealSearchAdapter extends RecyclerView.Adapter<MealSearchAdapter.MealHolder> {

    Context context;
    List<Meal> dataMeals;
    MealDataBaseHelper mDataBaseHelper;


    public MealSearchAdapter(Context context, List<Meal> list){
        this.context = context;
        dataMeals = list;
    }

    @NonNull
    @Override
    public MealHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.meal_item,parent,false);
        return new MealHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealHolder holder, int position) {

        Meal meal = dataMeals.get(position);
        holder.name.setText(meal.getName());
        holder.calories.setText(meal.getCalories().toString()+"cal");
        holder.protein.setText(meal.getProtein().toString());
        holder.carbs.setText(meal.getCarbs().toString());
        holder.fat.setText(meal.getFat().toString());
        holder.fiber.setText(meal.getFiber().toString());
        holder.servingSize.setText(meal.getServingSize().toString()+"gm");
        holder.addBUtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = meal.getName().toString();
                String caloreis = meal.getCalories().toString();
                String protein = meal.getProtein().toString();
                String carbs = meal.getCarbs().toString();
                String fat = meal.getFat().toString();
                String fiber = meal.getFiber().toString();
                Date c = Calendar.getInstance().getTime();
                System.out.println("Current time => " + c);
                //Toast.makeText(context, "Meal type is "+mealType, Toast.LENGTH_SHORT).show();

                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
                String formattedDate = df.format(c);
                AddData(name,caloreis, carbs, fat,fiber,protein,formattedDate);
                Toast.makeText(context, "Added to database!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataMeals.size();
    }

    public class MealHolder extends RecyclerView.ViewHolder {

        TextView name, calories, protein, carbs, fat, fiber, servingSize, addBUtton;

        public MealHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.meal_name);
            calories = itemView.findViewById(R.id.tvmeal_calories);
            protein = itemView.findViewById(R.id.tvProteinMeal);
            carbs = itemView.findViewById(R.id.tvCarbsMeal);
            fat = itemView.findViewById(R.id.tvFatMeal);
            fiber = itemView.findViewById(R.id.tvFibersMeal);
            servingSize = itemView.findViewById(R.id.tvServingSize);
            addBUtton = itemView.findViewById(R.id.tvAdd);
            mDataBaseHelper = new MealDataBaseHelper(context);

        }
    }

    public void AddData(String name, String calories, String carbs, String fat, String fiber, String protein,String date){
        boolean insertData = mDataBaseHelper.addData(name, calories, carbs, fat, fiber, protein, date);
        if(insertData){
            Toast.makeText(context, "Data Succefully Inserted!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Data insertion Fail! ", Toast.LENGTH_SHORT).show();
        }
    }
}
