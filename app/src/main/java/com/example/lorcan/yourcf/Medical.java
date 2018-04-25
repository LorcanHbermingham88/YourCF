package com.example.lorcan.yourcf;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.lorcan.yourcf.Common.Common;
import com.example.lorcan.yourcf.Model.MedicalProfile;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class Medical extends AppCompatActivity {

    MaterialEditText edtDoctor,edtDOB, edtSiblingsWithcF, edtdiabetes, edtAgeofPrognosis;
    Button btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_profile);

        edtDoctor = (MaterialEditText)findViewById(R.id.edtDoctor);
        edtDOB = (MaterialEditText)findViewById(R.id.edtDOB);
        edtSiblingsWithcF = (MaterialEditText)findViewById(R.id.edtSiblingsWithcF);
        edtdiabetes = (MaterialEditText)findViewById(R.id.edtdiabetes);
        edtAgeofPrognosis = (MaterialEditText)findViewById(R.id.edtAgeofPrognosis);
        btnProfile = (Button)findViewById(R.id.btnProfile);

        //Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_medical = database.getReference("Medical");

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog mDialog = new ProgressDialog(Medical.this);
                mDialog.setMessage("Please Wait....");
                mDialog.show();

                table_medical.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(edtDoctor.getText().toString()).exists())
                        {
                            mDialog.dismiss();
                            //Toast.makeText(Medical.this, "Phone Number Already Exists !!!", Toast.LENGTH_SHORT).show();
                                edtDOB.setText(Common.mCurrentUser.getDOB());
                                edtSiblingsWithcF.setText(Common.mCurrentUser.getSiblingWithCf());
                                edtdiabetes.setText(Common.mCurrentUser.getCfDiabetes());
                                edtAgeofPrognosis.setText(Common.mCurrentUser.getAgeOfPrognosis());
                        }
                        else
                        {
                            mDialog.dismiss();
                            MedicalProfile med = new MedicalProfile(edtDOB.getText().toString(),edtSiblingsWithcF.getText().toString(),edtdiabetes.getText().toString(),edtAgeofPrognosis.getText().toString());
                            table_medical.child(edtDoctor.getText().toString()).setValue(med);
                            Toast.makeText(Medical.this, "User Created", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
                Intent Medical = new Intent(com.example.lorcan.yourcf.Medical.this,MainActivity.class);
                startActivity(Medical);

            }
        });

    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Medical.this, Home.class));
        finish();
    }
}
