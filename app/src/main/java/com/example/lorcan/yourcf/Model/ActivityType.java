package com.example.lorcan.yourcf.Model;

/**
 * Created by lorcan on 04/04/18.
 */

public class ActivityType {

    private String IntensityOfActivity,Duration,Image, ActivityMenuId,Name,HeartRate,About;

    public ActivityType() {
    }

    public ActivityType(String intensityOfActivity, String duration, String image, String activityMenuId, String name, String heartRate, String about) {
        IntensityOfActivity = intensityOfActivity;
        Duration = duration;
        Image = image;
        ActivityMenuId = activityMenuId;
        Name = name;
        HeartRate = heartRate;
        About = about;
    }

    public String getIntensityOfActivity() {
        return IntensityOfActivity;
    }

    public void setIntensityOfActivity(String intensityOfActivity) {
        IntensityOfActivity = intensityOfActivity;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getActivityMenuId() {
        return ActivityMenuId;
    }

    public void setActivityMenuId(String activityMenuId) {
        ActivityMenuId = activityMenuId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getHeartRate() {
        return HeartRate;
    }

    public void setHeartRate(String heartRate) {
        HeartRate = heartRate;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }
}
