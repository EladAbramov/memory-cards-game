package com.example.memorygame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Settings extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ImageButton clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackToGame();
            }
        });
        ImageButton playMusic = findViewById(R.id.playMusic);
        playMusic.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Game.isPlay){
                    v.setBackgroundResource(R.drawable.play_button);
                    Game.isPlay=false;
                    MusicService.stopAudio();
                }else{
                    v.setBackgroundResource(R.drawable.stop);
                    Game.isPlay=true;
                }
            }
        });

    }
    public void goBackToGame() {
        Intent i = new Intent(this, Game.class);
        startActivity(i);
    }

}




