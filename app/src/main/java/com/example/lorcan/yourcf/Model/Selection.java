package com.example.lorcan.yourcf.Model;

public class Selection {
    private String Productid, ProductName,Quantity,Calories,CalorieAmount;

    public Selection() {
    }

    public Selection(String productid, String productName, String quantity, String calories, String calorieAmount) {
        Productid = productid;
        ProductName = productName;
        Quantity = quantity;
        Calories = calories;
        CalorieAmount = calorieAmount;
    }

    public String getProductid() {
        return Productid;
    }

    public void setProductid(String productid) {
        Productid = productid;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getCalories() {
        return Calories;
    }

    public void setCalories(String calories) {
        Calories = calories;
    }

    public String getCalorieAmount() {
        return CalorieAmount;
    }

    public void setCalorieAmount(String calorieAmount) {
        CalorieAmount = calorieAmount;
    }
}
