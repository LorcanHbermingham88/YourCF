package com.example.lorcan.yourcf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Zinc extends AppCompatActivity {

    Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zinc);

       button6 = (Button)findViewById(R.id.button6);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iron = new Intent(Zinc.this,Iron.class);
                startActivity(iron);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Zinc.this, Iron.class));
        finish();
    }
}
