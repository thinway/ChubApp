package org.thinway.weatherapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.thinway.weatherapp.model.Weather;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder> {

    private List<Weather> mWeatherList;

    public WeatherAdapter(List<Weather> weatherList) {
        mWeatherList = weatherList;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.temperature_list_row_item, parent, false);

        return new WeatherViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        Weather weather = mWeatherList.get(position);

        holder.max_temp.setText( weather.getMax_temp().toString() );
        holder.min_temp.setText( weather.getMin_temp().toString() );
        holder.weekday.setText( weather.getWeekday() );
    }

    @Override
    public int getItemCount() {
        return mWeatherList.size();
    }
}
