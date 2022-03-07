package com.example.mpishi;

import java.util.List;

public interface AppView {
    void showLoading();
    void hideLoading();
    void setAppData(List<AppData.Meal> meal);
    void onErrorLoading(String message);
}
