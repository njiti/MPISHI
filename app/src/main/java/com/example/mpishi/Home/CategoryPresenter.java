package com.example.mpishi.Home;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryPresenter {
    private CategoryView view;

    public CategoryPresenter(CategoryView view) {
        this.view = view;
    }

    void getMealByCategory(String category) {

        view.showLoading();
        Call<AppData> mealsCall = Utils.getApi().getMealByCategory(category);
        mealsCall.enqueue(new Callback<AppData>() {
            @Override
            public void onResponse(@NonNull Call<AppData> call,@NonNull Response<AppData> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.setMeals(response.body().getAppData());
                } else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<AppData> call,@NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }


    //
    void getMealCategory(String category) {

        view.showLoading();
        Call<AppData> mealsCall = Utils.getApi().getMealCategory(category);
        mealsCall.enqueue(new Callback<AppData>() {
            @Override
            public void onResponse(@NonNull Call<AppData> call,@NonNull Response<AppData> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.setMeals(response.body().getAppData());
                } else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<AppData> call,@NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });

    }

}
