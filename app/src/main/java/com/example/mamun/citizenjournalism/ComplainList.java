package com.example.mamun.citizenjournalism;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Mamun on 06-03-18.
 */

public class ComplainList extends AppCompatActivity {
    TextView tvDate;
    TextView tvDescription;
    TextView tvPlace;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complainlist);
        tvDate=findViewById(R.id.tvDate);
        tvDescription=findViewById(R.id.tvDescription);
        tvPlace=findViewById(R.id.tvPlace);
        DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
        String[]data=databaseHelper.my_data();
        tvDescription.setText(data[0]);


    }
}
