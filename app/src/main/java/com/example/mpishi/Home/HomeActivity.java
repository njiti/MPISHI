package com.example.mpishi.Home;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.mpishi.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements AppView {

    @BindView(R.id.viewPageHeader) ViewPager viewPagerAppData;
    @BindView(R.id.recyclerCategory) RecyclerView recyclerViewCategory;
    AppPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        presenter = new AppPresenter(this);
    }

    @Override
    public void showLoading() {
        findViewById(R.id.shimmerMeal).setVisibility(View.VISIBLE);
        findViewById(R.id.shimmerMeal).setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        findViewById(R.id.shimmerMeal).setVisibility(View.GONE);
        findViewById(R.id.shimmerMeal).setVisibility(View.GONE);
    }

    @Override
    public void setAppData(List<AppData.Meal> meal) {
        HomeAdapter headerAdapter = new HomeAdapter(meal, this);
        viewPagerAppData.setAdapter(headerAdapter);
        viewPagerAppData.setPadding(20, 0, 150, 0);
        headerAdapter.notifyDatasetChanged();
    }

    @Override
    public void onErrorLoading(String message) {

    }
}
