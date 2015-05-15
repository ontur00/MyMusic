package com.example.radog90.mymusic;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Wyglad oraz funkcje nowego okna
 * listView-> play music UI Thread
 */
public class PlayMusicUIThread extends ActionBarActivity {

    private TextView textView1;
    private boolean log_i = true;                   //Zmienna do wyswietlania log.i(...);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music_uithread);

        initializeGUI();
    }

    /**
     * Metoda która inicjalizuje GUI
     */
    private void initializeGUI() {
        textView1 = (TextView) findViewById(R.id.play_music_UI_Thread);

        //Pobierz zawartosc Resources
        Resources res = getResources();

        //Przekaz do String-a odpowiednia komorkie
        String[] tabStringFromRes = res.getStringArray(R.array.list_viewContainer);

        //Wyswietl zawartosc 0 komorki w textView   tab[0] = play music UI Thread
        textView1.setText(tabStringFromRes[0]);
    }

}
