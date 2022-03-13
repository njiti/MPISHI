package com.example.mpishi.Home;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppPresenter {
    private AppView view;


    public AppPresenter (AppView view){
        this.view = view;
   }
    void getAppData() {

        view.showLoading();

        Call<AppData> mealsCall = Utils.getApi().getAppData();
        mealsCall.enqueue(new Callback<AppData>() {
            @Override
            public void onResponse(@NonNull Call<AppData> call, @NonNull Response<AppData> response) {
                view.hideLoading();

                if (response.isSuccessful() && response.body() != null) {
                    view.setAppData(response.body().getAppData());
                }
                else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<AppData> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }

    void getCategories() {

        view.showLoading();

        Call<Categories> categoriesCall = Utils.getApi().getCategories();
        categoriesCall.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(@NonNull Call<Categories> call,@NonNull Response<Categories> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.setCategory(response.body().getCategories());
                }else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Categories> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
