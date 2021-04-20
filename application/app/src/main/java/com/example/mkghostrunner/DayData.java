package com.example.mkghostrunner;

import java.time.LocalDate;
import java.util.Date;

public class DayData {
    LocalDate day;
    String key;

    public DayData(){

    }
    public DayData(LocalDate day, String key){
        this.day = day;
        this.key = key;
    }

    public LocalDate getDay() {
        return this.day;
    }
    public String getKey(){
        return this.key;
    }



    public void setDay(LocalDate day){
        this.day = day;
    }
    public void setKey(String key){
        this.key = key;
    }
}
