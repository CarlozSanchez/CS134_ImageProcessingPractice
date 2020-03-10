package edu.miracosta.cs134.imageprocessingpractice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    // Constants
    static final int RESULT_LOAD_IMAGE = 1;

    ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
    Button mLoadImageButton;

    private Context context = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference View
        imageView1 = (ImageView) findViewById(R.id.standard_list_imageview1);
        imageView2 = (ImageView) findViewById(R.id.standard_list_imageview2);
        imageView3 = (ImageView) findViewById(R.id.standard_list_imageview3);
        imageView4 = (ImageView) findViewById(R.id.standard_list_imageview4);
        imageView5 = (ImageView) findViewById(R.id.standard_list_imageview5);

        mLoadImageButton = findViewById(R.id.loadImageButton);

        loadImageByInternetUrl();
        //loadImageByResourceID();
       // loadImageByFile();
    }

    public void onClick(View view)
    {
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == Activity.RESULT_OK)
        {
            switch(requestCode)
            {
                case RESULT_LOAD_IMAGE:
                    Uri selectedImage = data.getData();
                    //imageView1.setImageURI(selectedImage);
                    Glide.with(context).load(selectedImage).into(imageView1);
                    break;
            }
        }

    }

    private void loadImageByInternetUrl()
    {
        String internetUrl = "https://picsum.photos/400/600";

        Glide.with(context).load(internetUrl).into(imageView1);
    }

    private void loadImageByResourceID()
    {
        int resourceId = R.mipmap.ic_launcher;

        Glide.with(context).load(resourceId).into(imageView2);
    }

    private void loadBmpImage()
    {
       // int resourceID = R.drawable
    }

    private void loadImageByFile()
    {

        File imageFile = new File("C:\\Users\\Smashez\\Desktop\\safe.png");

        Log.i("file path", imageFile.toString());


       // Glide.with(context).load(imageFile).into(imageView3);
    }
}


/*
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data)
        {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn,
                    null,null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            imageView1.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
 */