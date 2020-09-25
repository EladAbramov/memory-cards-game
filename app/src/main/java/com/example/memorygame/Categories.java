package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Categories extends AppCompatActivity {
    String category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        Button clickButton = findViewById(R.id.start_button);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(category!=null){
                    startGame();

                }else{
                    final Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.setDuration(toast.LENGTH_LONG);
                    toast.makeText(getApplicationContext(),"You need to choose category" ,Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button animalsButton = findViewById(R.id.animals);
        animalsButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCategory("animals");
            }
        });

        Button foodkButton = findViewById(R.id.food);
        foodkButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCategory("food");
            }
        });

        Button carsButton = findViewById(R.id.cars);
        carsButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCategory("cars");
            }
        });
    }

    private void startGame() {
        String selectedCategory = PreferenceUtils.getCategory();
        int selectedDifficulty = PreferenceUtils.getDifficulty();

        Log.i("selectedCategory", "value = " + selectedCategory);
        Log.i("selectedDifficulty", "value = " + selectedDifficulty);
        if (selectedCategory.length() > 0 && selectedDifficulty > 0) {
            Intent i = new Intent(this, Game.class);
            startActivity(i);
        }
    }

    private void selectCategory(String _category) {
        category = _category;
        PreferenceUtils.setCategory(_category);
        Intent i = new Intent(this, Popup.class);
        startActivity(i);
    }
}
