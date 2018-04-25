package com.example.lorcan.yourcf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Run extends AppCompatActivity {

    Button btnH1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        btnH1 = (Button)findViewById(R.id.btnH1);

        btnH1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h1 = new Intent(Run.this,Home.class);
                startActivity(h1);
                finish();

            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Run.this, Home.class));
        finish();
    }
}
