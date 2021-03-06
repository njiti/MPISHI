package com.example.mpishi.Home;

import com.example.mpishi.Home.AppData;

import java.util.List;

import butterknife.internal.Utils;

public interface AppView {
    void showLoading();
    void hideLoading();
    void setAppData(List<AppData.Meal> meal);
    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);
}
