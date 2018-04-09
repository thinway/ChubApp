package org.thinway.weatherapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class WeatherViewHolder extends RecyclerView.ViewHolder {

    public TextView min_temp, max_temp, weekday;

    public WeatherViewHolder(View itemView) {
        super(itemView);
        min_temp = itemView.findViewById(R.id.min_temp_text_view);
        max_temp = itemView.findViewById(R.id.max_temp_text_view);
        weekday = itemView.findViewById(R.id.weekday_text_view);
    }
}
