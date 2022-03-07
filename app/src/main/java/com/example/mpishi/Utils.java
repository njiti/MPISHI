package com.example.mpishi;

import android.app.AlertDialog;
import android.content.Context;

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
