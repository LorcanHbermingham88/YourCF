package com.example.lorcan.yourcf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Salt extends AppCompatActivity {

    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salt);

        button5 = (Button)findViewById(R.id.button5);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iron = new Intent(Salt.this,Zinc.class);
                startActivity(iron);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Salt.this, Protein.class));
        finish();
    }
}
