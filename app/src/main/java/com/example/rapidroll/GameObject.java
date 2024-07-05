package com.example.rapidroll;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class GameObject {
    protected double x;
    protected double y;
    protected float size;
    protected double speed;
    protected int bitmapId;
    public Bitmap bitmap;
    protected Bitmap cBitmap;
    protected double halfWith;

    void init(Context context){
        cBitmap = BitmapFactory.decodeResource(context.getResources(), bitmapId);
        bitmap = Bitmap.createScaledBitmap(cBitmap, (int)(size*GameView.unitW*3), (int)(size*GameView.unitH/2),
                false);
        cBitmap.recycle();

    }

    void initBall(Context context){
        Bitmap cBitmap = BitmapFactory.decodeResource(context.getResources(), bitmapId);
        bitmap = Bitmap.createScaledBitmap(cBitmap, (int)(GameView.unitH), (int)(GameView.unitH), false);
        cBitmap.recycle();
        halfWith = GameView.surfaceHolder.getSurfaceFrame().width()/GameView.unitW/2;
    }

    void initHeart(Context context){
        Bitmap cBitmap = BitmapFactory.decodeResource(context.getResources(), bitmapId);
        bitmap = Bitmap.createScaledBitmap(cBitmap, (int)(GameView.unitW), (int)(GameView.unitH), false);
        cBitmap.recycle();
        halfWith = GameView.surfaceHolder.getSurfaceFrame().width()/GameView.unitW/2;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    public float getBitmapHeight(){
        return bitmap.getHeight()/GameView.unitH;
    }

    public float getBitmapWidth(){
        return bitmap.getWidth()/GameView.unitW;
    }

    void update(){
    }

    void drawing(Paint paint, Canvas canvas){
        canvas.drawBitmap(bitmap, (float)x*GameView.unitW,(float) y*GameView.unitH, paint);
    }
}
