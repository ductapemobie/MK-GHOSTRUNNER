package com.example.mkghostrunner;

public class RunData {
    long time;
    float dist;
    RunData nextRun;

    public RunData(long time, float dist){
        this.time = time;
        this.dist = dist;
    }

    public RunData getNextRun() {
        return this.nextRun;
    }
    public float getDist() {
        return this.dist;
    }
    public long getTime() {
        return this.time;
    }

    public void setNextRun(RunData nextRun) {
        this.nextRun = nextRun;
    }
}
