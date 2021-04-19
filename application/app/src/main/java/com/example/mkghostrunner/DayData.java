package com.example.mkghostrunner;

import java.util.Date;

public class DayData {
    Date day;
    DayData prevDay;
    RunData rootRun;
    FoodData rootFood;

    public DayData(Date day){
        this.day = day;
    }

    public Date getDay() {
        return this.day;
    }
    public DayData getPrevDay() {
        return this.prevDay;
    }
    public RunData getRootRun(){
        return this.rootRun;
    }
    public FoodData getRootFood() {
        return this.rootFood;
    }

    public void setPrevDay(DayData prevDay){
        this.prevDay = prevDay;
    }
    public void setRootFood(FoodData rootFood) {
        this.rootFood = rootFood;
    }
    public void setRootRun(RunData rootRun) {
        this.rootRun = rootRun;
    }
}
