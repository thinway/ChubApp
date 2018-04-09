package org.thinway.weatherapp.model;

public class Weather {

    private String weekday;
    private Double max_temp;
    private Double min_temp;
    private String status;

    public Weather() {
    }

    public Weather(String weekday, Double max_temp, Double min_temp) {
        this.weekday = weekday;
        this.max_temp = max_temp;
        this.min_temp = min_temp;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public Double getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(Double max_temp) {
        this.max_temp = max_temp;
    }

    public Double getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(Double min_temp) {
        this.min_temp = min_temp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
