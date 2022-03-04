package com.example.splashscreen;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class FourActivity extends AppCompatActivity {

    ObjectAnimator obj1;
    ObjectAnimator obj2;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_activity);

        LinearLayout effectLayout = findViewById(R.id.layout);

        //animation start

        //this in for for every item hooked
        AnimatorSet animationSet = new AnimatorSet();
        float valueFrom = 0f;
        float valueTo = 1f;
        obj1 = ObjectAnimator.ofFloat(effectLayout, "scaleX", valueFrom, valueTo);
        obj2 = ObjectAnimator.ofFloat(effectLayout, "scaleY", valueFrom, valueTo);
        obj1.setDuration(1000);
        obj2.setDuration(1000);
        animationSet.playTogether(obj1,obj2);
        animationSet.start();


        final TextView textAlready = findViewById(R.id.textNewUser);

        textAlready.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                AnimatorSet animationSet = new AnimatorSet();
                float valueFrom = 1f;
                float valueTo = 0.7f;
                obj1 = ObjectAnimator.ofFloat(textAlready, "scaleX", valueFrom, valueTo);
                obj2 = ObjectAnimator.ofFloat(textAlready, "scaleY", valueFrom, valueTo);
                obj1.setDuration(500);
                obj2.setDuration(500);
                animationSet.playTogether(obj1,obj2);
                animationSet.start();

                animationSet = new AnimatorSet();
                valueFrom = 0.7f;
                valueTo = 1f;
                obj1 = ObjectAnimator.ofFloat(textAlready, "scaleX", valueFrom, valueTo);
                obj2 = ObjectAnimator.ofFloat(textAlready, "scaleY", valueFrom, valueTo);
                obj1.setStartDelay(500);
                obj1.setDuration(500);
                obj2.setStartDelay(500);
                obj2.setDuration(500);
                animationSet.playTogether(obj1,obj2);
                animationSet.start();

                Thread timer = new Thread() {
                    public void run(){
                        try {
                            sleep(1000);
                            Intent intent = new Intent(FourActivity.this, ThirdActivity.class);
                            startActivity(intent);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                };
                timer.start();
            }
        });
    }
}

