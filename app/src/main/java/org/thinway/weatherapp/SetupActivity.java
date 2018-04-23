package org.thinway.weatherapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SetupActivity extends AppCompatActivity {

    private static final String TAG = SetupActivity.class.getName();

    ToggleButton unitsToggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        unitsToggleButton = findViewById(R.id.units_toggle_button);

        SharedPreferences prefs = getSharedPreferences(
                "data",
                Context.MODE_PRIVATE
        );
        String unit = prefs.getString("UNITS", "no_unit");

        if( unit.equals("metric") ){
            unitsToggleButton.setText("Metric");
            unitsToggleButton.setChecked(true);
        }else{
            unitsToggleButton.setText("Imperial");
            unitsToggleButton.setChecked(false);
        }

        showToolbar("Preferences", true);
    }

    private void showToolbar(String title, boolean upButton){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    private void saveUnits(String unit) {
        SharedPreferences prefs = getSharedPreferences(
                "data",
                Context.MODE_PRIVATE
        );

        SharedPreferences.Editor editorPrefs = prefs.edit();

        editorPrefs.putString("UNITS", unit);
        editorPrefs.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();

        String unit = unitsToggleButton.getText().toString().toLowerCase();

        Toast.makeText(
                getApplicationContext(),
                "Saving UNITS: " + unit,
                Toast.LENGTH_SHORT
        ).show();

        saveUnits(unit);
    }
}
