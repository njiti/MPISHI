package com.example.mpishi.Home;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AppApi {
    @GET("random.php")
    Call<AppData> getAppData();

    @GET("categories.php")
    Call<Categories> getCategories();

    @GET("filter.php")
    Call<AppData> getMealByCategory(@Query("c") String category);

    @GET("search.php")
    Call<AppData> getMealByName(@Query("s") String mealName);

}
