package com.example.mpishi.Home;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favourite")
public class MealFavourite {
    @PrimaryKey
    @NonNull
    public String idMeal;
    public String strMeal;
    public String strMealThumb;
}
