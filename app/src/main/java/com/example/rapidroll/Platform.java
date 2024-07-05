package com.example.rapidroll;

import android.content.Context;
import android.util.Log;

import com.example.my_framework.utils.UtilRandom;

import java.util.Random;

public class Platform extends GameObject {
    int rand;

    public Platform(Context context) {

        bitmapId = R.drawable.platform;
        size = 2;
        init(context);
        y = GameView.maxY;
        x = UtilRandom.getGap(0, (int)(GameView.maxX - bitmap.getWidth()/GameView.unitW));
        speed = 0.1;

    }

    @Override
    void update() {
        y -=speed;
    }
}
