package edu.miracosta.cs134.imageprocessingpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1, imageView2, imageView3, imageView4, imageView5;

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

        loadImageByInternetUrl();
        loadImageByResourceID();
        loadImageByFile();

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

    private void loadImageByFile()
    {

        File imageFile = new File("C:\\Users\\Smashez\\Desktop\\GekoLute.jpg");

        Log.i("file path", imageFile.toString());


        Glide.with(context).load(imageFile).into(imageView3);
    }
}
