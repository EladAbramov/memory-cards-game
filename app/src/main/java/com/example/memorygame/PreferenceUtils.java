package com.example.memorygame;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

class PreferenceUtils {
    private static Context context;
    private static SharedPreferences sharedPreferences;

    private static String NICKNAME_KEY = "NICKNAME_KEY";
    private static String CATEGORY_KEY = "CATEGORY_KEY";
    private static String DIFFICULTY_KEY = "DIFFICULTY_KEY";

    public static void setContext(Context applicationContext) {
        context = applicationContext;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setNickname(String nickname) {
//        String defaultValue = context.getResources().getString(R.string.nickname);
        sharedPreferences.edit().putString(NICKNAME_KEY, nickname).commit();
    }

    public static void setCategory(String category) {
//        String defaultValue = context.getResources().getString(R.string.nickname);
        sharedPreferences.edit().putString(CATEGORY_KEY, category).commit();
    }

    public static void setDifficulty(int difficulty) {
        sharedPreferences.edit().putInt(DIFFICULTY_KEY, difficulty).commit();
    }

    public static String getNickname() {
        String defaultValue = context.getResources().getString(R.string.nickname);
        String nickname = sharedPreferences.getString(NICKNAME_KEY, defaultValue);
        return nickname;
    }

    public static String getCategory() {
        String defaultValue = context.getResources().getString(R.string.category);
        String category = sharedPreferences.getString(CATEGORY_KEY, defaultValue);
        return category;
    }

    public static int getDifficulty() {
        int defaultValue = context.getResources().getInteger(R.integer.difficulty);
        int difficulty = sharedPreferences.getInt(DIFFICULTY_KEY, defaultValue);
        return difficulty;
    }
}

