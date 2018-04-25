package com.example.lorcan.yourcf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Calcium extends AppCompatActivity {

    Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcium);

        button8 = (Button)findViewById(R.id.button8);

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Calcium.this,Home.class);
                startActivity(home);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Calcium.this, Iron.class));
        finish();
    }
}
