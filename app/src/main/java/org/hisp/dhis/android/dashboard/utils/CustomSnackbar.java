package org.hisp.dhis.android.dashboard.utils;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

/**
 * Created by laavanye on 12/3/16.
 */
public class CustomSnackbar {
    public static void showSnackbar(View view, String message){
        Snackbar snackbar = Snackbar.make(view, message,
                Snackbar.LENGTH_LONG);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }
}
