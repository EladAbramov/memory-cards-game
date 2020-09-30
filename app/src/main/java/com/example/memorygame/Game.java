package com.example.memorygame;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game extends AppCompatActivity {

    public static boolean isPlay = true;
    private String selectedCategory;
    private int selectedDifficulty;
    List<Card> lstCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        selectedCategory = PreferenceUtils.getCategory();
        selectedDifficulty = PreferenceUtils.getDifficulty();
        setCards();
        RecyclerView myrv = findViewById(R.id.recyclerview_id);
        if(isPlay){
            MusicService.playAudio(this, R.raw.bgmusic);
        }
        ImageButton settingsButton = findViewById(R.id.settings);
        settingsButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicService.stopAudio();
                goToSettings();
            }
        });

        ImageButton backButton = findViewById(R.id.back);
        backButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicService.stopAudio();
                finish();

            }
        });
        ImageButton restartButton = findViewById(R.id.restart);
        restartButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicService.stopAudio();
                restart();
            }
        });

        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstCards, selectedDifficulty);
        myrv.setLayoutManager(new GridLayoutManager(this, getColNum()));
        myrv.setAdapter(myAdapter);


    }
    public void restart() {
        Intent i = new Intent(this, Game.class);
        startActivity(i);
    }
    public void goToSettings() {
        Intent i = new Intent(this, Settings.class);
        startActivity(i);
    }

    private int getColNum() {
        switch(selectedDifficulty) {
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
        lstCards.add(new Card("BIRD/ציפור","Categorie Book","Description book",R.drawable.bird));
        lstCards.add(new Card("BUG/חרק","Categorie Book","Description book",R.drawable.bug));
        lstCards.add(new Card("CAT/חתול","Categorie Book","Description book",R.drawable.cat));

        if (selectedDifficulty <= 3 && selectedDifficulty > 1) {
            lstCards.add(new Card("DOG/כלב","Categorie Book","Description book",R.drawable.dog));
            lstCards.add(new Card("ELEPHANT/פיל","Categorie Book","Description book",R.drawable.elephant));
            lstCards.add(new Card("FISH/דגים","Categorie Book","Description book",R.drawable.fish));
            lstCards.add(new Card("LION/אריה","Categorie Book","Description book",R.drawable.lion));
        }

        if (selectedDifficulty == 3) {
            lstCards.add(new Card("PENGUIN/פנגווין","Categorie Book","Description book",R.drawable.penguin));
            lstCards.add(new Card("RAT/עכבר","Categorie Book","Description book",R.drawable.rat));
            lstCards.add(new Card("ZEBRA/זברה","Categorie Book","Description book",R.drawable.zebra));
        }

        lstCards.addAll(lstCards);
        Collections.shuffle(lstCards);

    }

    private void setVehiclesCards() {
        lstCards.add(new Card("BYCYCLE/אופניים","Categorie Book","Description book",R.drawable.bicycle));
        lstCards.add(new Card("CAR/מכונית","Categorie Book","Description book",R.drawable.car));
        lstCards.add(new Card("HELICOPTER/הליקופטר","Categorie Book","Description book",R.drawable.helicopter));

        if (selectedDifficulty <= 3 && selectedDifficulty > 1) {
            lstCards.add(new Card("JEEP/ג׳יפ","Categorie Book","Description book",R.drawable.jeep));
            lstCards.add(new Card("MOPED/קטנוע","Categorie Book","Description book",R.drawable.moped));
            lstCards.add(new Card("MOTORCYCLE/אופנוע","Categorie Book","Description book",R.drawable.motorcycle));
            lstCards.add(new Card("PLANE/מטוס","Categorie Book","Description book",R.drawable.plane));
        }

        if (selectedDifficulty == 3) {
            lstCards.add(new Card("ROLLERBLADES/רולרבליידס","Categorie Book","Description book",R.drawable.rollerblades));
            lstCards.add(new Card("SCOOTER/קורקינט","Categorie Book","Description book",R.drawable.scooter));
            lstCards.add(new Card("TRUCK/משאית","Categorie Book","Description book",R.drawable.truck));
        }

        lstCards.addAll(lstCards);
        Collections.shuffle(lstCards);
    }

    private void setFoodCards() {
        lstCards.add(new Card("APPLE/תפוח","Categorie Book","Description book",R.drawable.apple));
        lstCards.add(new Card("BANANA/בננה","Categorie Book","Description book",R.drawable.banana));
        lstCards.add(new Card("BREAD/לחם","Categorie Book","Description book",R.drawable.bread));

        if (selectedDifficulty <= 3 && selectedDifficulty > 1) {
            lstCards.add(new Card("CARROT/גזר","Categorie Book","Description book",R.drawable.carrot));
            lstCards.add(new Card("CHERRIES/אוכמניות","Categorie Book","Description book",R.drawable.cherries));
            lstCards.add(new Card("CUCUMBER/מלפפון","Categorie Book","Description book",R.drawable.cucumber));
            lstCards.add(new Card("EGGPLANT/חציל","Categorie Book","Description book",R.drawable.eggplant));
        }

        if (selectedDifficulty == 3) {
            lstCards.add(new Card("MEAT/בשר","Categorie Book","Description book",R.drawable.meat));
            lstCards.add(new Card("EGGS/ביצים","Categorie Book","Description book",R.drawable.eggs));
            lstCards.add(new Card("TOMATO/עגבניה","Categorie Book","Description book",R.drawable.tomato));
        }

        lstCards.addAll(lstCards);
        Collections.shuffle(lstCards);
    }

}
