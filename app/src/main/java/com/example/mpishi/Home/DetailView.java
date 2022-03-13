package com.example.mpishi.Home;

public interface DetailView {
    void showLoading();
    void hideLoading();
    void setMeal(AppData.Meal meal);
    void onErrorLoading(String message);
}
