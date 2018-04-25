package com.example.lorcan.yourcf.Model;

/**
 * Created by lorcan on 14/03/18.
 */

public class Spirometer {

    private String Time;
    private String SpirometerResult;

    public Spirometer() {
    }

    public Spirometer(String time, String spirometerResult) {
        Time = time;
        SpirometerResult = spirometerResult;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getSpirometerResult() {
        return SpirometerResult;
    }

    public void setSpirometerResult(String spirometerResult) {
        SpirometerResult = spirometerResult;
    }
}


