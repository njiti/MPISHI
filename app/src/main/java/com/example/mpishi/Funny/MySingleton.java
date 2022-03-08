package com.example.mpishi.Funny;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class MySingleton {
    private static MySingleton instance;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private static Context ctx;

    private  MySingleton(Context context){
        ctx = context;
        requestQueue = getRequestQueue();

   }

    //Creating single instance
    public static MySingleton getInstance(Context context){
        if(instance == null){
            instance = new MySingleton(context);
        }
        return instance;
    }

    private RequestQueue getRequestQueue(){

        if(requestQueue==null){
            //getApplicationContext() is key, it keeps you from leaking the
            //Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }

        return requestQueue;
    }

    //To add the fetched objects to the request queue
    public <T> void addToRequestQueue(Request<T> req){
        getRequestQueue().add(req);
    }
    public ImageLoader getImageLoader(){
        return imageLoader;
    }
}

