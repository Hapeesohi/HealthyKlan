package com.example.healthyklan.modal;

public class Meal {
    String name;
    Double fiber;
    Double fat;
    Double calories;
    Double protein;
    Double carbs;
    Double servingSize;

    public Meal(String name, Double fiber, Double fat, Double calories, Double protein, Double carbs, Double servingSize) {
        this.name = name;
        this.fiber = fiber;
        this.fat = fat;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.servingSize = servingSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFiber() {
        return fiber;
    }

    public void setFiber(Double fiber) {
        this.fiber = fiber;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getCarbs() {
        return carbs;
    }

    public void setCarbs(Double carbs) {
        this.carbs = carbs;
    }

    public Double getServingSize() {
        return servingSize;
    }

    public void setServingSize(Double servingSize) {
        this.servingSize = servingSize;
    }

    public Meal(){

    }

}
