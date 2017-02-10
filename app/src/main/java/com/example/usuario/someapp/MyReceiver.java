package com.example.usuario.someapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by USUARIO on 09/02/2017.
 */

public class MyReceiver extends BroadcastReceiver{

    private static final String TAG = MyReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null && activeNetwork.isConnected()) {
            // do something
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                Toast.makeText(context, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();
                Log.i(TAG, "wifi");
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                Toast.makeText(context, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();
                Log.i(TAG, "mobile");
            }
        }else{
            Toast.makeText(context, "No connected", Toast.LENGTH_SHORT).show();
            Log.i(TAG, "no connected");
        }

    }
}
