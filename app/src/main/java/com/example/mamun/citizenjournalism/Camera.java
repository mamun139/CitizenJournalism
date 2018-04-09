package com.example.mamun.citizenjournalism;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mamun on 06-03-18.
 */

public class Camera extends AppCompatActivity {
    ImageView ivCamera;
    Button btnTakePhoto;
    EditText etDescription;
    Button btnSubmit;
    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnTakePhoto = (Button) findViewById(R.id.btnTakePhoto);
        ivCamera = findViewById(R.id.ivCamera);
        etDescription=findViewById(R.id.etDescription);
        btnSubmit=findViewById(R.id.btnSubmit);
        final DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }

            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description=etDescription.getText().toString();
                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                String location="Dhaka";
                DataTemp dt=new DataTemp(date,location,description);
                databaseHelper.addingDataToTable(dt);
                Toast.makeText(Camera.this, "Your request has been successfully submitted."+description+date+location, Toast.LENGTH_SHORT).show();
                Log.e("data...........", "onClick:................ "+date+location+description );
                Intent intent=new Intent(Camera.this,Dashboard.class);
                startActivity(intent);

            }
        });


    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ivCamera.setImageBitmap(imageBitmap);
        }
    }
}
