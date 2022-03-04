package com.example.splashscreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.splashscreen.Bike;
import com.example.splashscreen.R;

import java.util.ArrayList;

public class BikesAdapter extends ArrayAdapter<Bike> {

    public BikesAdapter(@NonNull Context context, ArrayList<Bike> davidBowieArrayList) {
        super(context, 0, davidBowieArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return setImageText(position,convertView,parent,0);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return setImageText(position,convertView,parent,1);
    }

    public View setImageText( int position, View convertView, ViewGroup parent, Integer pos) {

        if (convertView == null) {
            //inflate convertView
            int layout = R.layout.spinner_row;
            if (pos == 0) layout = R.layout.spinner_row;
            if (pos == 1) layout = R.layout.spinner_row_drop;

            convertView = LayoutInflater.from(getContext()).inflate(
                    layout,
                    parent,
                    false
            );
        }
        ImageView image = convertView.findViewById(R.id.imageView);
        TextView text = convertView.findViewById(R.id.textView);

        Bike currentBike = getItem(position);

        if (currentBike != null) {
            image.setImageResource(currentBike.getImgBike());
            text.setText(currentBike.getNameBike());
        }
        return convertView;
    }
}
