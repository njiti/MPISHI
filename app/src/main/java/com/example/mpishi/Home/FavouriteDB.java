package com.example.mpishi.Home;

import android.content.Context;
import android.sax.RootElement;

import androidx.room.Database;
import androidx.room.Room;

@Database(entities = {MealFavourite.class}, version = 1, exportSchema = false)
public class FavouriteDB extends RootDatabase {
    public abstract FavouriteDAO favoriteDAO();

    private static FavouriteDB INSTANCE;

    public static FavouriteDB getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (FavouriteDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, FavouriteDB.class, "favorite.db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
