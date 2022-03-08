package com.example.mpishi.Home;

import android.app.AlertDialog;
import android.content.Context;

import com.example.mpishi.Home.AppApi;
import com.example.mpishi.Home.AppClient;

public class Utils {

    public static AppApi getApi(){
        return AppClient.getAppClient().create(AppApi.class);
    }

    public static AlertDialog showDialogMessage(Context context, String title, String message){
        AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title).setMessage(message).show();
            if (alertDialog.isShowing()){
                alertDialog.cancel();
            }
            return alertDialog;
    }
}
