package com.example.radog90.mymusic.AllServices;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import com.example.radog90.mymusic.R;

/**
 * Created by radog90 on 2015-05-17.
 * Testowy Service aby sprawdzic czy aby nie laguje GUI
 */
public class MyService extends Service {
    MediaPlayer mediaPlayer;

    public void onCreate() {
        Log.i("Service", "MyService onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //TODO do owszystkie tryby odtwarzania play/pause stop
        Log.i("Service", "MyService onStartCommand");

        if (mediaPlayer == null) {
            //Zalaczenie muzyki w Service
            mediaPlayer = MediaPlayer.create(
                    getBaseContext(), R.drawable.adb);
            Log.i("Service", "Duration Music " + mediaPlayer.getDuration());
            mediaPlayer.start();
        } else {
            String message = intent.getStringExtra("Action");

            //Co mam wykonać Play/Pause Stop
            if (message == "Pause") {
                if( mediaPlayer.isPlaying() ) {
                    //Pausowanie muzyki
                    mediaPlayer.pause();
                }
            } else if (message == "Stop") {
                if( mediaPlayer.isPlaying() ) {
                    //Stop-owanie muzyki
                    mediaPlayer.stop();
                }
            } else if (message == "Play") {
                //play muzyki
                mediaPlayer.start();
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

        //Wylaczenie muzyki w Service
        mediaPlayer.stop();
        super.onDestroy();
    }
}
