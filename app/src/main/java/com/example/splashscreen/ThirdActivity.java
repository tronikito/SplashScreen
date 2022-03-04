package com.example.splashscreen;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class ThirdActivity extends AppCompatActivity {

    ObjectAnimator obj1;
    ObjectAnimator obj2;
    private Spinner spinnerClass;
    private Adapter bikesAdapter;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        //overridePendingTransition(R.anim.out,R.anim.in);

        //hook

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

        //spinner

        ArrayList arrayBikes = new ArrayList<Bike>();

        Bike d1 = new Bike("MTB",R.drawable.ic_bicycle);
        Bike d2 = new Bike("GRAVEL",R.drawable.ic_bicycle);
        Bike d3 = new Bike("BMX",R.drawable.ic_bicycle);
        Bike d4 = new Bike("ROAD",R.drawable.ic_bicycle);
        arrayBikes.add(d1);
        arrayBikes.add(d2);
        arrayBikes.add(d3);
        arrayBikes.add(d4);

        spinnerClass = findViewById(R.id.spinnerClass);

        bikesAdapter = new BikesAdapter(this, (ArrayList<Bike>) arrayBikes);

        spinnerClass.setAdapter((SpinnerAdapter) bikesAdapter);
        /*
        spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Bike currentBike = (Bike) parent.getItemAtPosition(position);
                String coverName = currentBike.getNameBike();
                Toast.makeText(ThirdActivity.this, coverName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ThirdActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });*/

        final TextView textDate = findViewById(R.id.editTextDate);

        textDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                DatePickerDialog picker = new DatePickerDialog(ThirdActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                textDate.setText(i2 + "/" + (i1 + 1) + "/" + i);
                            }
                        },year,month,day);
                picker.show();
            }
        });

        final TextView textAlready = findViewById(R.id.textAlready);

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
                            Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
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
