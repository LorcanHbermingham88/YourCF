package com.example.lorcan.yourcf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lorcan.yourcf.Model.Food;

public class Protein extends AppCompatActivity {

    Button btnSalt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protein);

        btnSalt = (Button) findViewById(R.id.button3);

        btnSalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pg = new Intent(Protein.this, Salt.class);
                startActivity(pg);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Protein.this, FoodFacts.class));
        finish();
    }
}


