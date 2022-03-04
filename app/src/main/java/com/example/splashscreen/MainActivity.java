package com.example.splashscreen;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    public static int SPLASH_SCREEN = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hooks

        imageView = findViewById(R.id.imageLogo);
        textView = findViewById(R.id.textTitle);

        Runnable r = new Runnable() {

            @Override
            public void run() {

                //intent
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(imageView, "imageapp");
                pairs[1] = new Pair<View,String>(textView, "textapp");

                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                    startActivity(i,options.toBundle());
                }

            }
        };

        Handler h = new Handler(Looper.getMainLooper());
        h.postDelayed(r,SPLASH_SCREEN);
    }
}