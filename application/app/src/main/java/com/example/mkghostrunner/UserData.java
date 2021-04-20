package com.example.mkghostrunner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class UserData {
    String username, password;
    //List<DayData> dayDataList;

    public UserData(){

    }
    public UserData(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    /*public List<DayData> getDayDataList() {
        return this.dayDataList;
    }*/

    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }

    /*public void addDayData(DayData dayData) {
        this.dayDataList.add(dayData);
    }*/
}
