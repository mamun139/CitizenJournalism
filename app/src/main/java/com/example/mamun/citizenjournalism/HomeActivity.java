package com.example.mamun.citizenjournalism;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;

/**
 * Created by Mamun on 02-03-18.
 */

public class HomeActivity extends AppCompatActivity {

   // @BindView(R.id.ivCamera)
    ImageView ivCamera;
   // @BindView(R.id.btnTakePhoto)
    Button btnTakePhoto;
    @BindView(R.id.etDescription)
    EditText etDescription;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;
    static final int CAM_REQUEST=1;
    final int THUMBSIZE = 64;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
      //  ButterKnife.bind(this);
        btnTakePhoto=(Button) findViewById(R.id.btnTakePhoto);
        ivCamera=findViewById(R.id.ivCamera);
        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File pictureDirectory= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                String pictureName=getPicturename();
                File imageFile=new File(pictureDirectory,pictureName);
                Uri pictureUri=Uri.fromFile(imageFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,pictureUri);
                startActivityForResult(cameraIntent,CAM_REQUEST);
               // File file=getFile();
                //cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
               /* if (cameraIntent.resolveActivity(getPackageManager())!=null){
                    startActivityForResult(cameraIntent,CAM_REQUEST);
                }*/
            }
        });

    }

    private String getPicturename() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timeStamp=sdf.format(new Date());
        return timeStamp+".jpg";
    }

    private File getFile()
    {
        File folder=new File("sdcard/camera_app");
        if (folder.exists()){
            folder.mkdir();
        }
        File imageFile=new File(folder,"cam_image.jpg");
        return imageFile;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    //String path="sdcard/camera_app/cam_image.jpg";
   super.onActivityResult(requestCode,resultCode,data);
    if (requestCode==CAM_REQUEST && requestCode==RESULT_OK){
      /*  Bundle extras=data.getExtras();
        Bitmap imageBitmap= (Bitmap) extras.get("data");*/

        File pictureDirectory= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        String pictureName=getPicturename();
        File imageFile=new File(pictureDirectory,pictureName);
        Uri pictureUri=Uri.fromFile(imageFile);
        Bitmap imageBitmap = ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(pictureUri.getPath()),
                THUMBSIZE, THUMBSIZE);
        ivCamera.setImageBitmap(imageBitmap);

    }
      //  ivCamera.setImageDrawable(Drawable.createFromPath(path));
    }
}
