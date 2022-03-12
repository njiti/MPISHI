package com.example.mpishi.Home;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

public class Utils {

    public static AppApi getApi() {
        return AppClient.getAppClient().create(AppApi.class);
    }

    public static AlertDialog showDialogMessage(Context context, String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title).setMessage(message).show();
        if (alertDialog.isShowing()) {
            alertDialog.cancel();
        }
        return alertDialog;
    }
}