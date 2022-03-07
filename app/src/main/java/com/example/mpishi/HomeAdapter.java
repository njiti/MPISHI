package com.example.mpishi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class HomeAdapter extends PagerAdapter {
    private List<AppData.Meal> meals;
    private Context context;
    private static ClickListener clickListener;

    public HomeAdapter(List<AppData.Meal> meals, Context context){
        this.meals = meals;
        this.context = context;
    }
    public void setOnItemClickListener(ClickListener clickListener){
        HomeAdapter.clickListener = clickListener;
    }
    @Override
    public int getCount(){
        return meals.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o){
        return view.equals(o);
    }
    @NonNull
    public Object instatiateItem(@NonNull ViewGroup container, int position){
        View view = LayoutInflater.from(context).inflate(
                R.layout.item_view_pager_header,
                container,
                false
        );

        ImageView mealThumb = View.findViewById(R.id.mealthumb);
        TextView mealName = view.findViewById(R.id.mealName);

        String strMealThumb = meals.get(position).getStrMealThumb();
        Picasso.get().load(strMealThumb).into(mealThumb);

        String strMealName = meals.get(position).getStrMeal();
        mealName.setText(strMealName);

        view.setOnClickListener(v -> clickListener.onClick(v, position));

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    public interface ClickListener {
        void onClick(View v, int position);
    }
}
