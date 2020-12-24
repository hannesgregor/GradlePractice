package com.weather.models;


import com.weather.models.Day;
import com.weather.models.Night;

import java.util.List;

public class Forecast_date {
    private List<Night> nights;
    private List<Day> days;


    public Forecast_date(String night, String day) {

    }

    public List<Night> getNights() {
        return nights;
    }

    public void setNights(List<Night> nights) {
        this.nights = nights;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Forecast_date{" +
                "nights=" + nights +
                ", days=" + days +
                '}';
    }

}

