package com.example.rapidroll;

import android.content.Context;

import com.example.my_framework.utils.UtilRandom;

public class Heart extends GameObject {

    public Heart(Context context, double xP, double yP) {
        bitmapId = R.drawable.heart;
        size = 5;
        initHeart(context);
        x = xP + UtilRandom.getGap(0, 5);
        y = yP;
        speed = 0.1f;
    }

    @Override
    void update() {
        y-=speed;

    }

}
