package com.example.lorcan.yourcf;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class InformationPage2 extends AppCompatActivity {

    private ImageView one = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_page2);

        one = (ImageView)findViewById(R.id.howTo);

        one.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.youtube.com/watch?v=tmugorD2DpM"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }});



    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(InformationPage2.this, Home.class));
        finish();
    }




}
