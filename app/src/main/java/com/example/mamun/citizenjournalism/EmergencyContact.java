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

public class EmergencyContact extends AppCompatActivity {
    CardView cvPolice;
    CardView cvFireService;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergencycontact);
        cvFireService=findViewById(R.id.cvFireService);
        cvPolice=findViewById(R.id.cvPolice);
        cvPolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EmergencyContact.this,EmergencyPolice.class);
                startActivity(intent);
            }
        });
        cvFireService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EmergencyContact.this,EmergencyFrireService.class);
                startActivity(intent);
            }
        });
    }
}
