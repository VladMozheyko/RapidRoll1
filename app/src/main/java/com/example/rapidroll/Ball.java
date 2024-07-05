package com.example.rapidroll;

import android.content.Context;

import com.example.my_framework.SoundFW;

public class Ball extends GameObject {
    private float radB, radP;
    private double xP;
    private boolean hit, reachedEndL, reachedEndR, reachedEndOnPlatform;
    public static SoundFW sound;

    public Ball(Context context) {
        bitmapId = R.drawable.ball;
        size = 5;
        initBall(context);
        x = halfWith;
        y = 7;
        speed = 0.2f;
        hit = false;
        sound = GameActivity.getAudio().newSound("takeHeart.wav");
    }

    @Override
    void update() {
        reachedEndL = false;
        reachedEndR = false;
        if(x <=0.1*getBitmapWidth()  ){
            x = 0;
            reachedEndL = true;
        }
        if(x+ getBitmapWidth()>= GameView.maxX-0.1*getBitmapWidth()){
            x = GameView.maxX - bitmap.getWidth()/GameView.unitW;
            reachedEndR = true;
        }
        reachedEndOnPlatform = false;
        movement();
        radB = (float)Math.sqrt(Math.pow(getBitmapHeight()/2, 2) + Math.pow(getBitmapHeight()/2, 2));
        for (Platform platform: GameView.platforms) {
            radP = (float) Math.sqrt(Math.pow(platform.getBitmapHeight() / 2, 2) + Math.pow(platform.getBitmapHeight() / 2, 2));
          if(hitPlatform(platform, radB, radP)){
              if(reachedСeiling()){
                  GameView.lives--;
                  hit = true;
              }
              return;
          }
          if(y >= (platform.getY() - platform.getBitmapHeight()) && y - getBitmapHeight()  < platform.getY()
          && x + getBitmapWidth() + 0.3 > platform.getX() && x + getBitmapWidth() + 0.3 < platform.getX() + 1 ){
              x = platform.getX()- getBitmapWidth();
                  speed = 0.2f;
                  y += speed;
                  return;
          }

            if(y >= (platform.getY() - platform.getBitmapHeight()) && y - getBitmapHeight()  < platform.getY()
                    && x  - 0.3 < platform.getX()+platform.getBitmapWidth() && x - 0.3 > platform.getX()
                    + getBitmapWidth() - 1){
                x = platform.getX() + platform.getBitmapWidth();
                speed = 0.2f;
                y += speed;
                return;
            }
          hitHeart();
        }

        for (Spikes spikes: GameView.spikesArr) {
            if(hitSpikes(spikes)){
                GameView.lives = GameView.lives - 1;
                hit = true;
                return;
            }
        }
        if(reachedFloor()){
            GameView.lives = GameView.lives - 1;
            hit = true;
            return;
        }
        speed = 0.2f;
        y += speed;
    }

    private boolean reachedFloor() {
        if(y >= GameView.maxY){
            return true;
        }
        return false;
    }

    private boolean reachedСeiling() {
        if(y <= 1.5){
          return true;
        }
        else
            return false;
    }

    private void hitHeart() {
        if(GameView.isHeart && y <= GameView.heart.getY() && y >= (GameView.heart.getY() - GameView.heart.getBitmapHeight())
        && x + getBitmapWidth() >= GameView.heart.getX() && GameView.heart.getX() + GameView.heart.getBitmapWidth()>= x){
            GameView.lives++;
            sound.play(1);
            GameView.isHeart = false;
        }
    }

    private boolean hitSpikes(Spikes spikes){
        if (y - getBitmapHeight() <= spikes.getY() && y >= spikes.getY() - 1.1*spikes.getBitmapHeight()
        && x + getBitmapWidth() >= spikes.getX() && x <= spikes.getX() + spikes.getBitmapWidth()) {
            hit = true;
            return true;
        }
        else
            return false;
    }

    private boolean hitPlatform(Platform platform, float radB, float radP){
        if (platform.getY() - platform.getBitmapHeight() / 2 - y + getBitmapHeight() / 2 >= (radP + radB) * 0.5
                && platform.getY() - platform.getBitmapHeight() / 2 - y + getBitmapHeight() / 2 <=
                (radP + radB) && x + getBitmapWidth() * 0.65 >= platform.getX() &&
                x + getBitmapWidth() * 0.4 < (platform.getX() + platform.getBitmapWidth())
        ||platform.getY() - platform.getBitmapHeight() / 2 - y + getBitmapHeight() / 2 >= (radP + radB) * 0.5
                && platform.getY() - platform.getBitmapHeight() / 2 - y + getBitmapHeight() / 2 <=
                (radP + radB) && platform.getX()-getBitmapWidth() <= 0 && x <= platform.getX()
        ||platform.getY() - platform.getBitmapHeight() / 2 - y + getBitmapHeight() / 2 >= (radP + radB) * 0.5
                && platform.getY() - platform.getBitmapHeight() / 2 - y + getBitmapHeight() / 2 <=
                (radP + radB) &&  GameView.maxX - platform.getX() - platform.getBitmapWidth() < getBitmapWidth()
                && x + getBitmapWidth() >= platform.getX() + platform.getBitmapWidth()) {
            if(reachedEndL && platform.getX() > 0.1) {
                reachedEndOnPlatform = true;
            }
            if(reachedEndR &&  platform.getX()+ platform.getBitmapWidth() < GameView.maxX - 0.1*getBitmapWidth())
            {
                reachedEndOnPlatform = true;
            }
            if(reachedEndOnPlatform){
                y = platform.getY() - 0.8*platform.getBitmapHeight();
            }
            else {
                y = platform.getY() - platform.getBitmapHeight();
            }
            y -= platform.getSpeed();
            speed = -1;
            return true;
        }
        else
            return false;
    }



    private void movement() {

        if(GameActivity.isIsLeftPressed() && x > 0 ){
            x -= 0.3;
        }
        if(GameActivity.isIsRightPressed() && x < GameView.maxX - bitmap.getWidth()/GameView.unitW  ){

            x += 0.3;
        }
    }

    public boolean isHit() {
        return hit;
    }
}
