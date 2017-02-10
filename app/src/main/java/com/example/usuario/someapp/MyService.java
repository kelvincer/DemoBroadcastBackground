package com.example.usuario.someapp;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by USUARIO on 10/02/2017.
 */

public class MyService extends Service {

    private static final String TAG = MyService.class.getSimpleName();
    private static MyReceiver m_ScreenOffReceiver;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        registerScreenOffReceiver();
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(m_ScreenOffReceiver);
        m_ScreenOffReceiver = null;
        Log.i(TAG, "service destroy");
    }

    private void registerScreenOffReceiver() {

        m_ScreenOffReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(m_ScreenOffReceiver, intentFilter);
    }
}