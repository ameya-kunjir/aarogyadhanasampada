package com.example.android.aarogyadhanasampda;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuthenticateActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    String parentActivity;
    private Bitmap mImageBitmap;
    private String mCurrentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authenticate);
        parentActivity = getIntent().getStringExtra("caller");
        System.out.println("Parent Caller " + parentActivity);
    }

    public void navigateToOtherScreen(View view) {
        if (parentActivity.equalsIgnoreCase("login")) {
            Intent intent = new Intent(this, RegistrationActivity.class);
            startActivity(intent);
        } else if (parentActivity.equalsIgnoreCase("addclaim")) {
            Intent intent = new Intent(this, AddClaimActivity.class);
            startActivity(intent);
        }
    }

    public void captureEyeImage(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }

            // Continue only if the File was successfully created
            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }

    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);
        // Save a file: path for use with ACTION_VIEW intents
        // mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        mCurrentPhotoPath = image.getAbsolutePath();
        System.out.println("Image path " + mCurrentPhotoPath);
        return image;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            try {
                // mImageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), Uri.parse(mCurrentPhotoPath));
                mImageBitmap = BitmapFactory.decodeFile(mCurrentPhotoPath);
                ImageView imgView = (ImageView) findViewById(R.id.eye_image);
                imgView.setImageBitmap(mImageBitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
