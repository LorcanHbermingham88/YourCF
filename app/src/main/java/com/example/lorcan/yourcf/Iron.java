package com.example.lorcan.yourcf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Iron extends AppCompatActivity {

    Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iron);

        button7 = (Button)findViewById(R.id.button7);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cal = new Intent(Iron.this, Calcium.class);
                startActivity(cal);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Iron.this, Zinc.class));
        finish();
    }
}
