package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game extends AppCompatActivity {

    private String selectedCategory;
    private int selectedDifficulty;

    List<Card> lstCards ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        selectedCategory = PreferenceUtils.getCategory();
        selectedDifficulty = PreferenceUtils.getDifficulty();

        setCards();

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstCards, selectedDifficulty);

        myrv.setLayoutManager(new GridLayoutManager(this, getColNum()));
        myrv.setAdapter(myAdapter);
    }

    private int getColNum() {
        switch(selectedDifficulty) {
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            default:
                return 2;
        }
    }

    private void setCards() {
        lstCards = new ArrayList<>();

        switch(selectedCategory) {
            case "animals":
                setAnimalsCards();
                break;
            case "food":
                setFoodCards();
                break;
            case "cars":
                setVehiclesCards();
                break;
            default:
                break;
        }
    }

    private void setAnimalsCards() {
        lstCards.add(new Card("BIRD","Categorie Book","Description book",R.drawable.bird));
        lstCards.add(new Card("BUG","Categorie Book","Description book",R.drawable.bug));
        lstCards.add(new Card("CAT","Categorie Book","Description book",R.drawable.cat));

        if (selectedDifficulty <= 3 && selectedDifficulty > 1) {
            lstCards.add(new Card("DOG","Categorie Book","Description book",R.drawable.dog));
            lstCards.add(new Card("ELEPHANT","Categorie Book","Description book",R.drawable.elephant));
            lstCards.add(new Card("FISH","Categorie Book","Description book",R.drawable.fish));
            lstCards.add(new Card("LION","Categorie Book","Description book",R.drawable.lion));
        }

        if (selectedDifficulty == 3) {
            lstCards.add(new Card("PENGUIN","Categorie Book","Description book",R.drawable.penguin));
            lstCards.add(new Card("RAT","Categorie Book","Description book",R.drawable.rat));
            lstCards.add(new Card("ZEBRA","Categorie Book","Description book",R.drawable.zebra));
        }

        lstCards.addAll(lstCards);
        Collections.shuffle(lstCards);
    }

    private void setVehiclesCards() {
        lstCards.add(new Card("BYCYCLE","Categorie Book","Description book",R.drawable.bicycle));
        lstCards.add(new Card("CAR","Categorie Book","Description book",R.drawable.car));
        lstCards.add(new Card("HELICOPTER","Categorie Book","Description book",R.drawable.helicopter));

        if (selectedDifficulty <= 3 && selectedDifficulty > 1) {
            lstCards.add(new Card("JEEP","Categorie Book","Description book",R.drawable.jeep));
            lstCards.add(new Card("MOPED","Categorie Book","Description book",R.drawable.moped));
            lstCards.add(new Card("MOTORCYCLE","Categorie Book","Description book",R.drawable.motorcycle));
            lstCards.add(new Card("PLANE","Categorie Book","Description book",R.drawable.plane));
        }

        if (selectedDifficulty == 3) {
            lstCards.add(new Card("ROLLERBLADES","Categorie Book","Description book",R.drawable.rollerblades));
            lstCards.add(new Card("SCOOTER","Categorie Book","Description book",R.drawable.scooter));
            lstCards.add(new Card("TRUCK","Categorie Book","Description book",R.drawable.truck));
        }

        lstCards.addAll(lstCards);
        Collections.shuffle(lstCards);
    }

    private void setFoodCards() {
        lstCards.add(new Card("APPLE","Categorie Book","Description book",R.drawable.apple));
        lstCards.add(new Card("BANANA","Categorie Book","Description book",R.drawable.banana));
        lstCards.add(new Card("BREAD","Categorie Book","Description book",R.drawable.bread));

        if (selectedDifficulty <= 3 && selectedDifficulty > 1) {
            lstCards.add(new Card("CARROT","Categorie Book","Description book",R.drawable.carrot));
            lstCards.add(new Card("CHERRIES","Categorie Book","Description book",R.drawable.cherries));
            lstCards.add(new Card("CUCUMBER","Categorie Book","Description book",R.drawable.cucumber));
            lstCards.add(new Card("EGGPLANT","Categorie Book","Description book",R.drawable.eggplant));
        }

        if (selectedDifficulty == 3) {
            lstCards.add(new Card("MEAT","Categorie Book","Description book",R.drawable.meat));
            lstCards.add(new Card("EGGS","Categorie Book","Description book",R.drawable.eggs));
            lstCards.add(new Card("TOMATO","Categorie Book","Description book",R.drawable.tomato));
        }

        lstCards.addAll(lstCards);
        Collections.shuffle(lstCards);
    }

}
