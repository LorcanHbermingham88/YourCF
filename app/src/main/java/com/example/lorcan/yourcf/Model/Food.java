package com.example.lorcan.yourcf.Model;

/**
 * Created by Lorcan on 03/04/2018.
 */

public class Food {

          private String Cal,Description,OverallCalAmount,Image,MenuId,Name;

    public Food() {
    }

    public Food(String cal, String description, String overallCalAmount, String image, String menuId, String name) {
        Cal = cal;
        Description = description;
        OverallCalAmount = overallCalAmount;
        Image = image;
        MenuId = menuId;
        Name = name;
    }

    public String getCal() {
        return Cal;
    }

    public void setCal(String cal) {
        Cal = cal;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getOverallCalAmount() {
        return OverallCalAmount;
    }

    public void setOverallCalAmount(String overallCalAmount) {
        OverallCalAmount = overallCalAmount;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
