package com.example.mpishi;

import androidx.annotation.NonNull;

import butterknife.internal.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppPresenter {
    private AppView view;

    public class AppPresenter(AppView view){
        this.view = view;
    }
    void getMeals() {

        view.showLoading();

        Call<AppData> mealsCall = Utils.getApi().getMeal();
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
}
