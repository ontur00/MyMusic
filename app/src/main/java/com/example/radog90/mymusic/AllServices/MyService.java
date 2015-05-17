package com.example.radog90.mymusic.AllServices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by radog90 on 2015-05-17.
 * Testowy Service aby sprawdzic czy aby nie laguje GUI
 */
public class MyService extends Service {

    public void onCreate(){
        Log.i("Service", "MyService onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //TODO do something usefuls
        Log.i("Service", "MyService onStartCommand");

        //Sprawdzenie czy service dziala na glownym watku UI , Uspienie na 2 sekundy
        for(int i=0; i < 5; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Log.i("Service", "MyService onDestroy");
        super.onDestroy();
    }
}
