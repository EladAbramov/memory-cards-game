package com.example.memorygame;

import android.content.Context;
import android.media.MediaPlayer;

public class MusicService {

    public static MediaPlayer mediaPlayer;
    public static boolean isplayingAudio=false;
    public static void playAudio(Context c,int id){
        mediaPlayer = MediaPlayer.create(c,id);
        if(!mediaPlayer.isPlaying())
        {
            isplayingAudio=true;
            mediaPlayer.start();
        }
    }
    public static void stopAudio(){
        isplayingAudio=false;
        mediaPlayer.stop();
    }
}