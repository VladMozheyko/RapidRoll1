package com.example.rapidroll;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_framework.Core;
import com.example.my_framework.Scene;
import com.example.rapidroll.scenes.GameScene;

public class MainActivity extends AppCompatActivity {


    Button btnContinue, btnExit, btnInformation, btnNewGame;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getUIItems();


    }

    public void getUIItems(){
//        btnContinue = (Button)findViewById(R.id.btnContinue);
//        btnExit= (Button)findViewById(R.id.btnExit);
//        btnInformation = (Button)findViewById(R.id.btnInformation);
//        btnNewGame = (Button)findViewById(R.id.btnNewGame);

       // title = (TextView)findViewById(R.id.title);
      //  setFonts();
    }

    private void setFonts(){
        Typeface typeface = Typeface.createFromAsset(getAssets(), "my-font.ttf");
        title.setTypeface(typeface);
        btnNewGame.setTypeface(typeface);
        btnInformation.setTypeface(typeface);
        btnContinue.setTypeface(typeface);
        btnExit.setTypeface(typeface);
    }

    public void onClick(View view) {
//        Intent intent;
//        switch (view.getId()){
//            case R.id.btnNewGame:
//                intent = new Intent(this, GameActivity.class);
//                startActivity(intent);
//                break;
//
//        }
    }
}
