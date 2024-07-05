package com.example.rapidroll;

import android.content.Context;

import com.example.my_framework.utils.UtilRandom;

public class Spikes extends GameObject {

    public Spikes(Context context) {
        bitmapId = R.drawable.platform2;
        size = 2;
        init(context);
        y = GameView.maxY;
        x = UtilRandom.getGap(0, (int)(GameView.maxX - bitmap.getWidth()/GameView.unitW));

        speed = 0.1f;
    }

    @Override
    void update() {
        y -= speed;
    }
}
