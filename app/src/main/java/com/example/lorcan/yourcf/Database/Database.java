package com.example.lorcan.yourcf.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.lorcan.yourcf.Model.Selection;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {

    private static final String DB_NAME="FoodDB.db";
    private static final int DB_VER = 1;

    public Database(Context context) {
        super(context, DB_NAME, null,  DB_VER);
    }

    public List<Selection> getSelections()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"ProductName","Quantity","Calories","CalorieAmount"};
        String sqlTable = "SelectionDetail";

        qb.setTables(sqlTable);

        Cursor c = qb.query(db,sqlSelect,null,null,null,null,null);

        final List<Selection> result = new ArrayList<>();

        if(c.moveToFirst())
        {
            do{
                result.add(new Selection(c.getString(c.getColumnIndex("ProductId")),
                           c.getString(c.getColumnIndex("ProductName")),
                           c.getString(c.getColumnIndex("Quantity")),
                           c.getString(c.getColumnIndex("Calories")),
                           c.getString(c.getColumnIndex("CalorieAmount"))




                ));
            }while(c.moveToNext());
        }
        return result;
    }

    public void addToSelection (Selection selection)
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("INSERT INTO SelectionDetail(ProductId,ProductName,Quantity,Calories,CalorieAmount) VALUES('%S','%S','%S','%S','%S',);",
                selection.getProductid(),
                selection.getProductName(),
                selection.getCalories(),
                selection.getCalorieAmount());
        db.execSQL(query);
    }

    public void cleanSelection (Selection selection)
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("DELETE FROM SelectionDetail");
        db.execSQL(query);
    }
}
