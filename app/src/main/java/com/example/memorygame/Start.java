package com.example.memorygame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Start extends AppCompatActivity {

    private EditText nicknameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button clickButton = findViewById(R.id.categories);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCategories();
            }
        });
        nicknameInput = findViewById(R.id.nickname);
        Context applicationContext = this;
        PreferenceUtils.setContext(applicationContext);
    }


    public void selectCategories() {
        String nickname = nicknameInput.getText().toString();
        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(toast.LENGTH_LONG);
        toast.makeText(getApplicationContext(),"Hello " + nickname ,Toast.LENGTH_SHORT).show();

        if (nickname.length() > 0) {
            PreferenceUtils.setNickname(nickname);
            Intent i = new Intent(this, Categories.class);
            startActivity(i);
        }
    }
}
