package com.example.mpishi.Home;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavouriteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(MealFavourite meal);

    @Query("SELECT * FROM favourite")
    List<MealFavourite> select();

    @Query("DELETE FROM favourite WHERE strMeal = :name")
    void delete(String name);

    @Query("SELECT * FROM favourite WHERE strMeal = :name")
    boolean isFavorite(String name);
}
