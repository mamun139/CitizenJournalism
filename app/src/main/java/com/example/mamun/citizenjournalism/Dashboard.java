package com.example.mamun.citizenjournalism;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by Mamun on 06-03-18.
 */

public class Dashboard extends AppCompatActivity {
    CardView cvComplainSubmit;
    CardView cvComplainList;
    CardView cvProfile;
    CardView cvFeedback;
    CardView cvEmergencyContact;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        cvComplainSubmit=findViewById(R.id.cvComplainSubmit);
        cvComplainList=findViewById(R.id.cvComplainList);
        cvProfile=findViewById(R.id.cvProfile);
        cvFeedback=findViewById(R.id.cvFeedback);
        cvEmergencyContact=findViewById(R.id.cvEmergencyContact);

        cvComplainSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,Camera.class);
                startActivity(intent);
            }
        });
        cvComplainList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,ComplainList.class);
                startActivity(intent);
            }
        });
        cvProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,Profile.class);
                startActivity(intent);
            }
        });
        cvFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,Feedback.class);
                startActivity(intent);
            }
        });
        cvEmergencyContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,EmergencyContact.class);
                startActivity(intent);
            }
        });

    }
}
