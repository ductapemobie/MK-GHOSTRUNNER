package com.example.mkghostrunner;

public class UserData {
    String username, password;
    DayData headDay;

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
    public DayData getHeadDay() {
        return this.headDay;
    }
    public void setHeadDay(DayData headDay) {
        this.headDay = headDay;
    }
}
