package com.example.splashscreen;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    ObjectAnimator obj1;
    ObjectAnimator obj2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        //hooks
        LinearLayout effectLayout = findViewById(R.id.layout);

        //animation start

        AnimatorSet animationSet = new AnimatorSet();
        float valueFrom = 0f;
        float valueTo = 1f;
        obj1 = ObjectAnimator.ofFloat(effectLayout, "scaleX", valueFrom, valueTo);
        obj2 = ObjectAnimator.ofFloat(effectLayout, "scaleY", valueFrom, valueTo);
        obj1.setDuration(1000);
        obj2.setDuration(1000);
        animationSet.playTogether(obj1,obj2);
        animationSet.start();


        //NewUser text
        final TextView textNewUser = findViewById(R.id.textNewUser);

        textNewUser.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                AnimatorSet animationSet = new AnimatorSet();
                float valueFrom = 1f;
                float valueTo = 0.7f;
                obj1 = ObjectAnimator.ofFloat(textNewUser, "scaleX", valueFrom, valueTo);
                obj2 = ObjectAnimator.ofFloat(textNewUser, "scaleY", valueFrom, valueTo);
                obj1.setDuration(500);
                obj2.setDuration(500);
                animationSet.playTogether(obj1,obj2);
                animationSet.start();

                animationSet = new AnimatorSet();
                valueFrom = 0.7f;
                valueTo = 1f;
                obj1 = ObjectAnimator.ofFloat(textNewUser, "scaleX", valueFrom, valueTo);
                obj2 = ObjectAnimator.ofFloat(textNewUser, "scaleY", valueFrom, valueTo);
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
                            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                            startActivity(intent);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                };
                timer.start();
            }
        });
        //Forgot password?

        final TextView textForgotPass = findViewById(R.id.textForgot);

        textForgotPass.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                AnimatorSet animationSet = new AnimatorSet();
                float valueFrom = 1f;
                float valueTo = 0.7f;
                obj1 = ObjectAnimator.ofFloat(textForgotPass, "scaleX", valueFrom, valueTo);
                obj2 = ObjectAnimator.ofFloat(textForgotPass, "scaleY", valueFrom, valueTo);
                obj1.setDuration(500);
                obj2.setDuration(500);
                animationSet.playTogether(obj1,obj2);
                animationSet.start();

                animationSet = new AnimatorSet();
                valueFrom = 0.7f;
                valueTo = 1f;
                obj1 = ObjectAnimator.ofFloat(textForgotPass, "scaleX", valueFrom, valueTo);
                obj2 = ObjectAnimator.ofFloat(textForgotPass, "scaleY", valueFrom, valueTo);
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
                            Intent intent = new Intent(SecondActivity.this, FourActivity.class);
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