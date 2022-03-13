package com.example.mpishi.Home;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MealFavourite.class}, version = 1, exportSchema = false)
public abstract class FavouriteDB extends RoomDatabase {
    public abstract FavouriteDAO favouriteDAO();

    private static FavouriteDB INSTANCE;

    public static FavouriteDB getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (FavouriteDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, FavouriteDB.class, "favourite.db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
