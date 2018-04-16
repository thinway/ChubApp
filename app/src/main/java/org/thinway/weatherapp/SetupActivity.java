package org.thinway.weatherapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SetupActivity extends AppCompatActivity {

    private static final String TAG = SetupActivity.class.getName();

    ToggleButton unitsToggleButton;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        unitsToggleButton = findViewById(R.id.units_toggle_button);
        saveButton = findViewById(R.id.save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unit = unitsToggleButton.getText().toString();

                Toast.makeText(
                        getApplicationContext(),
                        "Saving UNITS: " + unit,
                        Toast.LENGTH_SHORT
                ).show();

                saveUnits(unit);
            }
        });
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
}
