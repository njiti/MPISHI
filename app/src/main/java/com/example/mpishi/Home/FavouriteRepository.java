package com.example.mpishi.Home;

import android.app.Application;

import java.util.List;

public class FavouriteRepository {
    private FavouriteDAO favouriteDAO;

    public FavouriteRepository(Application application) {
        FavouriteDB database = FavouriteDB.getDatabase(application);
        favouriteDAO = database.favouriteDAO();
    }

    public void insert(MealFavourite meal) {
        favouriteDAO.insert(meal);
    }

    public void delete(String name) {
        favouriteDAO.delete(name);
    }

    public List<MealFavourite> select() {
        return favouriteDAO.select();
    }

    public boolean isFavourite(String name) {
        return favouriteDAO.isFavorite(name);
    }
}
