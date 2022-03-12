package com.example.mpishi.Home;

import com.example.mpishi.Home.AppData;

import java.util.List;

public interface CategoryView {
    void showLoading();
    void hideLoading();
    void setMeals(List<AppData.Meal> meals);
    void onErrorLoading(String message);
}
