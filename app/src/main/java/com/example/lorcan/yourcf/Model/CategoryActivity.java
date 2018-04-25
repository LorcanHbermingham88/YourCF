package com.example.lorcan.yourcf.Model;

/**
 * Created by Lorcan on 11/03/2018.
 */

public class CategoryActivity {

    private String Name;
    private String Image;

    public CategoryActivity() {
    }

    public CategoryActivity(String name, String image) {
        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
