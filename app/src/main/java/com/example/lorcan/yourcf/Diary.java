package com.example.lorcan.yourcf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.example.lorcan.yourcf.Database.Database;
import com.example.lorcan.yourcf.Model.Selection;
import com.example.lorcan.yourcf.ViewHolder.SelectionAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Diary extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference request;

    TextView txtSelection;
    Button btnPlace;

    List<Selection> listDate = new ArrayList<>();

    SelectionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        //Firebase
        database = FirebaseDatabase.getInstance();
        request = database.getReference("Requests");

        //init
        recyclerView = (RecyclerView)findViewById(R.id.listDiary);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        txtSelection = (TextView)findViewById(R.id.total);
        btnPlace = (Button)findViewById(R.id.btnAddDiary);

        loadListFood();
    }

    private void loadListFood() {
        listDate = new Database(this).getSelections();
        adapter = new SelectionAdapter(listDate,this);
        recyclerView.setAdapter(adapter);

        int total = 0;
        for(Selection selection:listDate){
            total+=(Integer.parseInt(selection.getCalorieAmount()))*(Integer.parseInt(selection.getQuantity()));
            Locale locale = new Locale("en","US");
            NumberFormat fmt =NumberFormat.getCurrencyInstance(locale);
            txtSelection.setText(fmt.format(total));
        }

    }
}
