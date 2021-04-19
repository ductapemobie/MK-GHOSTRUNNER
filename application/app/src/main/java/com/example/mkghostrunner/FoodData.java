package com.example.mkghostrunner;

public class FoodData {
    String name, dayKey, key;
    int calories, carbs, protein, fat;
    //FoodData next = null;

    public FoodData(){

    }
    public FoodData(int calories, int carbs, int protein, int fat, String name, String dayKey, String key){
        this.calories = calories;
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
        this.name = name;
        this.dayKey = dayKey;
        this.key = key;
    }

    public String getName() {
        return this.name;
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
    public String getDayKey(){
        return this.dayKey;
    }
    public String getKey(){
        return this.key;
    }
    /*public FoodData getNext(){
        return this.next;
    }*/

    public void setName(String name){
        this.name = name;
    }
    public void setCalories(int calories){
        this.calories = calories;
    }
    public void setCarbs(int carbs){
        this.carbs = carbs;
    }
    public void setProtein(int protein){
        this.protein = protein;
    }
    public void setFat(int fat) {
        this.fat = fat;
    }
    public void setDayKey(String dayKey) {
        this.dayKey = dayKey;
    }
    public void setKey(String key) {
        this.key = key;
    }
    /*public void setNext(FoodData next) {
        this.next = next;
    }*/

}
