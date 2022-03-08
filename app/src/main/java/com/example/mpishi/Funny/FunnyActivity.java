package com.example.mpishi.Funny;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.mpishi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class FunnyActivity extends AppCompatActivity {

    RecyclerView rView;
    ArrayList<DataModel> dataModelArrayList = new ArrayList<>();
    DataAdapter dataAdapter;

    public static final  String API_KEY = "N5cLjjjk65LMfdc3muilgNZUhU8TpV12";//API Key
    public static final String BASE_URL = "https://api.giphy.com/v1/gifs/trending?api_key=";

    String url = BASE_URL+API_KEY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funny);

        rView = findViewById(R.id.recyclerView);
        rView.setLayoutManager(new GridLayoutManager(this,2));
        rView.setHasFixedSize(true);

        //Getting the data
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET,url,null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response){
                JSONArray dataArray = null;
                try {
                    dataArray = response.getJSONArray("data");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                for (int i=0;i<dataArray.length();i++){
                    JSONObject obj = null;
                    try {
                        obj = dataArray.getJSONObject(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    JSONObject obj1 = null;
                    try {
                        obj1 = obj.getJSONObject("images");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    JSONObject obj2 = null;
                    try {
                        obj2 = obj1.getJSONObject("downsized_medium");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    String sourceUrl = null;
                    try {
                        sourceUrl = obj2.getString("url");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    dataModelArrayList.add(new DataModel(sourceUrl));
                }
                dataAdapter = new DataAdapter(FunnyActivity.this,dataModelArrayList);
                rView.setAdapter(dataAdapter);
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText(FunnyActivity.this, "Error"+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        MySingleton.getInstance(this).addToRequestQueue(objectRequest);
    }
}
