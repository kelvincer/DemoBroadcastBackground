package com.example.usuario.someapp;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
      /*  this.registerReceiver(this.mConnReceiver,
                new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));*/

       /* MyReceiver receiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(receiver, intentFilter);*/

        Intent service = new Intent(this, MyService.class);
        startService(service);
    }

    /*private BroadcastReceiver mConnReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            *//*boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            String reason = intent.getStringExtra(ConnectivityManager.EXTRA_REASON);
            boolean isFailover = intent.getBooleanExtra(ConnectivityManager.EXTRA_IS_FAILOVER, false);

            NetworkInfo currentNetworkInfo = (NetworkInfo) intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            NetworkInfo otherNetworkInfo = (NetworkInfo) intent.getParcelableExtra(ConnectivityManager.EXTRA_OTHER_NETWORK_INFO);

            if(currentNetworkInfo.isConnected()){
                Toast.makeText(getApplicationContext(), "Connected", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(), "Not Connected", Toast.LENGTH_LONG).show();
            }*//*

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

            *//*if (activeNetwork != null) { // connected to the internet
                if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                    // connected to wifi
                    Toast.makeText(context, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();
                } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                    // connected to the mobile provider's data plan
                    Toast.makeText(context, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();
                }
            } else {
                // not connected to the internet
                Toast.makeText(context, "No connected", Toast.LENGTH_SHORT).show();
            }*//*
        }
    };*/
}

