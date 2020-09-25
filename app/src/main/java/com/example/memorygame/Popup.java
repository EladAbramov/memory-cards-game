package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class Popup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8), (int)(height*0.6));

        Button easyButton = findViewById(R.id.easy);
        easyButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDifficulty(1);
            }
        });

        Button mediumButton = findViewById(R.id.medium);
        mediumButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDifficulty(2);
            }
        });

        Button hardButton = findViewById(R.id.hard);
        hardButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDifficulty(3);
            }
        });
    }

    private void setDifficulty(int dif) {
        PreferenceUtils.setDifficulty(dif);
        finish();
    }
}
