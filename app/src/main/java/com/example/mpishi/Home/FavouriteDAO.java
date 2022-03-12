package com.example.mpishi.Home;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mpishi.Home.MealFavourite;

import java.util.List;

@Dao
public class FavouriteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(MealFavourite meal);

    @Query("SELECT * FROM favorite")
    List<MealFavourite> select();

    @Query("DELETE FROM favorite WHERE strMeal = :name")
    void delete(String name);

    @Query("SELECT * FROM favorite WHERE strMeal = :name")
    boolean isFavorite(String name);
}
