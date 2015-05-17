package com.example.radog90.mymusic;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Wyglad oraz funkcje nowego okna
 * listView-> play music UI Thread
 */
public class PlayMusicUIThread extends ActionBarActivity {

    private TextView textView1;
    private boolean log_i = true;                   //Zmienna do wyswietlania log.i(...);
    private Button previousSong;
    private ToggleButton playPause;

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
        //inicjalizujaca buttonow
        initializeButtons();

        textView1 = (TextView) findViewById(R.id.Album_Name);

        //Pobierz zawartosc Resources
        Resources res = getResources();

        //Przekaz do String-a odpowiednia komorkie
        String[] tabStringFromRes = res.getStringArray(R.array.list_viewContainer);

        //Wyswietl zawartosc 0 komorki w textView   tab[0] = play music UI Thread
        textView1.setText(tabStringFromRes[0]);
    }

    /**
     * Metoda inicjalizujaca wszystkie buttony
     */
    private void initializeButtons() {
        //Buton dla poprzedniej piosenki
        previousSong = (Button) findViewById(R.id.previous_Song);

        //Akcja dla buttona, zalaczenie poprzedniej piosenki
        ButtonsListener listener = new ButtonsListener();
        previousSong.setOnClickListener(listener);

        //Akcja dla buttona przy długim kliknieciu
        ButtonsLongClickListener longListener = new ButtonsLongClickListener();
        previousSong.setOnLongClickListener(longListener);

        //ToggleButton dodanie akcji Play/Pause muzyki
        playPause = (ToggleButton) findViewById(R.id.play_Pause);
        PlayPauseToggleListener playPauseToggleListener = new PlayPauseToggleListener();
        playPause.setOnCheckedChangeListener(playPauseToggleListener);
    }

    /**
     * implementacja Listenerow dla wszystkich button-ow
     */
    private class ButtonsListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.previous_Song:
                    Toast.makeText(PlayMusicUIThread.this,
                            "previous Song click", Toast.LENGTH_SHORT).show();
                    MediaPlayer mediaPlayer = MediaPlayer.create(
                            getBaseContext(), R.drawable.adb);
                    mediaPlayer.start();
                    break;
            }
        }
    }

    /**
     * implementacja OnItemLongClickListener dla wszystkich button-ow
     */
    private class ButtonsLongClickListener implements View.OnLongClickListener {

        @Override
        public boolean onLongClick(View v) {

            switch (v.getId()) {

                case R.id.previous_Song:
                    Toast.makeText(getApplicationContext(),
                            "previous Song LONG CLICK", Toast.LENGTH_SHORT).show();
                    return true;
            }

            return false;
        }
    }

    /**
     * implementacja dla ToogleButtona
     * ktory ma za zadanie Pause/Play muzyki
     */
    private class PlayPauseToggleListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


            if (isChecked){
                //Toggle Button ...
                Toast.makeText(getApplicationContext(),
                        String.valueOf(isChecked), Toast.LENGTH_SHORT).show();
            }else{
                //Toggle Button ...
                Toast.makeText(getApplicationContext(),
                        String.valueOf(isChecked), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
