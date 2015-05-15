package com.example.radog90.mymusic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends Activity {
    private ListView listView;
    private TextView textView1;
    private ArrayList<String> listString = null;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeGUI();

    }

    private void initializeGUI() {
        initlializeListView();
        initializeTextView();

    }

    private void initializeTextView() {
        //attach textView and textView from activity_main.xml
        textView1 = (TextView) findViewById(R.id.textView1);

        //Create String[] for ListView from Resources
        Resources res = getResources();
        String[] tabStringFromRes = res.getStringArray(R.array.list_viewContainer);

        //StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tabStringFromRes.length; i++) {
            stringBuilder.append(tabStringFromRes[i] + "\n");
        }

        //StringBuilder transfer to String
        String stringFromBuilder = stringBuilder.toString();

        //Set text
        textView1.setText(stringFromBuilder);
    }

    private void initlializeListView() {
        //Create String[] for ListView from Resources
        Resources res = getResources();
        String[] tabStringFromRes = res.getStringArray(R.array.list_viewContainer);

        //Transfer string-array to ArrayList
        listString = new ArrayList<String>();
        for (int i = 0; i < 15; i++) {
            listString.add(i, tabStringFromRes[i]);
        }

        String[] tabString = {"1", "2", "3"};

        //transfer tabStrinFromRes to StringBuilder
//        StringBuilder sBuilder = toStringBuilder(tabStringFromRes);

        //Build ArrayAdapter
        StableArrayAdapter stableArrayAdapter = new StableArrayAdapter(
                this, android.R.layout.simple_list_item_1, listString);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, tabStringFromRes);

        //Toast.makeText(this, tabStringFromRes.toString(), Toast.LENGTH_LONG).show();

        //initialize listView
        listView = (ListView) findViewById(R.id.listView3);

        //Set adapter for listView
        listView.setAdapter(stableArrayAdapter);

        //Set listView listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                /*
                //Delete element from listView
                tabStringFromRes.
                .notifyDataSetChanged();
                view.setAlpha(1);
                */
                if (position == 0) {
                    Toast.makeText(getApplicationContext(),
                            String.valueOf(position), Toast.LENGTH_SHORT).show();
                    goToActivityPlayMusciUIThread();
                } else {
                    Log.i("debug listView", String.valueOf(position));
                }
            }

            private void goToActivityPlayMusciUIThread() {
                Intent intent = new Intent(getBaseContext(), PlayMusicUIThread.class);
                startActivity(intent);
            }
        });
    }


    /*
    private StringBuilder toStringBuilder(String[] tabStringFromRes) {
        StringBuilder sBuilder = new StringBuilder();

        //transfer tabStringFromRes to sBuilder
        for(int i=0; i<tabStringFromRes.length; i++){
            sBuilder.append(tabStringFromRes[i] + "\n")
        }
        return null;
    }
    */


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Selected action settings"
                    , Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        /**
         * HashMap przechowuje zawartość ArrayList
         * ArrayList = Resources.getStringArray(R.array.list_viewContainer)
         * Zawartość HashMap będzie wyświetlana w listView
         */
        HashMap<String, Integer> hMap = new HashMap<String, Integer>();

        /**
         * @param context
         * @param resource
         * @param listString = ArrayList = Resources.getStringArray(R.array.list_viewContainer)
         */
        public StableArrayAdapter(Context context, int resource,
                                  List<String> listString) {

            super(context, resource, listString);

            //Przekopiowanie List do HashMap
            for (int i = 0; i < listString.size(); i++) {
                hMap.put(listString.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return super.getItemId(position);
        }

        @Override
        public boolean hasStableIds() {
            return super.hasStableIds();
        }
    }
}
