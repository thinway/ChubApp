package org.thinway.weatherapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.thinway.weatherapp.model.Weather;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private List<Weather> mWeatherList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private WeatherAdapter mWeatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showUnitsState();

        mRecyclerView = findViewById(R.id.list_temperatures_recycler_view);

        mWeatherAdapter = new WeatherAdapter(mWeatherList);
        RecyclerView.LayoutManager layoutManager
                = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator( new DefaultItemAnimator() );
        mRecyclerView.setAdapter( mWeatherAdapter );

        loadWeatherData();

    }

    @Override
    protected void onStart() {
        super.onStart();

        showUnitsState();

    }

    private void showUnitsState(){
        SharedPreferences prefs = getSharedPreferences(
                "data",
                Context.MODE_PRIVATE
        );
        String unit = prefs.getString("UNITS", "metrico");
        Log.d(TAG, "UNITS: " + unit);
    }

    private void loadWeatherData(){
        Weather weather = new Weather("Lunes", 23.2, 13.5);
        mWeatherList.add( weather );

        weather = new Weather("Lunes", 23.2, 13.5);
        mWeatherList.add( weather );

        weather = new Weather("Lunes", 23.2, 13.5);
        mWeatherList.add( weather );

        weather = new Weather("Lunes", 23.2, 13.5);
        mWeatherList.add( weather );

        weather = new Weather("Lunes", 23.2, 13.5);
        mWeatherList.add( weather );

        weather = new Weather("Lunes", 23.2, 13.5);
        mWeatherList.add( weather );

        weather = new Weather("Lunes", 23.2, 13.5);
        mWeatherList.add( weather );

        weather = new Weather("Lunes", 23.2, 13.5);
        mWeatherList.add( weather );

        weather = new Weather("Lunes", 23.2, 13.5);
        mWeatherList.add( weather );

        weather = new Weather("Lunes", 23.2, 13.5);
        mWeatherList.add( weather );

        weather = new Weather("Lunes", 23.2, 13.5);
        mWeatherList.add( weather );

        mWeatherAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.mainmenu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = null;

        switch ( id ) {
            case R.id.about_menu_item:
                intent = new Intent(getApplicationContext(), AboutActivity.class);
                break;
            case R.id.settings_menu_item:
                intent = new Intent(getApplicationContext(), SetupActivity.class);
                break;
        }

        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }
}
