package com.example.rapidroll.scenes;

import android.graphics.Color;

import com.example.my_framework.Core;
import com.example.my_framework.Scene;

public class MainMenuScene extends Scene {

    public MainMenuScene(Core core) {
        super(core);

    }

    @Override
    public void update() {


    }

    @Override
    public void resume() {

    }

    @Override
    public void drawing() {
        getGraphics().drawText("Новая игра", 50, 300, Color.BLUE, 40, null);

    }

    @Override
    public void dispose() {

    }

    @Override
    public void pause() {

    }
}
