package com.example.mkghostrunner;

public class FoodData {
    String name;
    int calories, carbs, protein, fat;
    FoodData next = null;

    public FoodData(int calories, int carbs, int protein, int fat, String name){
        this.calories = calories;
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
        this.name = name;
    }

    public int getCalories() {
        return this.calories;
    }
    public int getCarbs(){
        return this.carbs;
    }
    public int getProtein(){
        return this.protein;
    }
    public int getFat(){
        return this.fat;
    }
    public FoodData getNext(){
        return this.next;
    }
    public void setNext(FoodData next) {
        this.next = next;
    }
}
