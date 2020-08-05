package com.example.a6nimmt.menu;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.a6nimmt.R;

public class ChangeBackground extends Fragment {

    public ChangeBackground() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_change_background, container, false);
        ImageView imageView = v.findViewById(R.id.red_image);
        Glide.with(this).load(R.drawable.red_color).centerCrop().into(imageView);
        imageView = v.findViewById(R.id.dark_image);
        Glide.with(this).load(R.drawable.dark_blue).centerCrop().into(imageView);
        imageView = v.findViewById(R.id.colorful_image);
        Glide.with(this).load(R.drawable.bright_colors).centerCrop().into(imageView);
        imageView = v.findViewById(R.id.white);
        Glide.with(this).load(R.drawable.white_wood).centerCrop().into(imageView);
        return v;
    }

}
