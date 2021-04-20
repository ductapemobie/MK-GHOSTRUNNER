package com.example.mkghostrunner;

public class RunData {
    long time;
    float dist;
    String key;

    public RunData(){

    }
    public RunData(long time, float dist, String key){
        this.time = time;
        this.dist = dist;
        this.key = key;
    }

    public float getDist() {
        return this.dist;
    }
    public long getTime() {
        return this.time;
    }
    public String getKey() {
        return this.key;
    }

    public void setDist(float dist) {
        this.dist = dist;
    }
    public void setTime(long time) {
        this.time = time;
    }
    public void setKey(String key) {
        this.key = key;
    }
}
