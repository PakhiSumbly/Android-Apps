package com.pakhi.cameraapp;

import static android.Manifest.permission.CAMERA;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    Button button;
    public static final int CAMERA_PERMISSION_CODE=1;
    public static final int CAMERA_IMAGE_CODE=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
        button = findViewById(R.id.btnCamera);

        button.setOnClickListener(this::onClick);
    }

    private void onClick (View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(CAMERA) != PackageManager.PERMISSION_GRANTED) {  //using camera is not allowed
                String[] permissions = {CAMERA};

                requestPermissions(permissions, CAMERA_PERMISSION_CODE);
            } else { // camera is allowed to be used
                takepicture();
            }
        } else {
            takepicture();
        }
    }

        @Override
        public void onRequestPermissionsResult(int requestCode, String[] permissions, @NonNull int[] grantResults)
        {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);

            if (requestCode == CAMERA_PERMISSION_CODE) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    takepicture();
                } else {
                    Toast.makeText(this, "App needs permissions for using camera", Toast.LENGTH_SHORT).show();
                }
            }
        }

       @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data)
        {
            if(requestCode==CAMERA_IMAGE_CODE)
            {
                if(resultCode==RESULT_OK)
                {// WE HAVE A PICTURE
                    Bitmap takenImage= (Bitmap) data.getExtras().get("data");
                    image.setImageBitmap(takenImage);
                }
            }
            super.onActivityResult(requestCode, resultCode, data);
        }

        private void takepicture()
        {
            Intent CameraIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(CameraIntent,CAMERA_IMAGE_CODE);
        }
    }