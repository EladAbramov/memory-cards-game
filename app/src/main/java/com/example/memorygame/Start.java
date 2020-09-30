package com.example.memorygame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
        toast.setDuration(Toast.LENGTH_LONG);
        Toast.makeText(getApplicationContext(),"Hello " + nickname ,Toast.LENGTH_SHORT).show();

        if (nickname.length() > 0) {
            PreferenceUtils.setNickname(nickname);
            Intent i = new Intent(this, Categories.class);
            startActivity(i);
        }
    }
}
