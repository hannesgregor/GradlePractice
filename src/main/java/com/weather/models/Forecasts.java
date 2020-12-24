package com.weather.models;

import java.util.Date;
import java.util.List;

public class Forecasts {

    private List<Forecast_date> forecasts;

    public Forecasts(Date forecast_date) {
    }

    public List<Forecast_date> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast_date> forecasts) {
        this.forecasts = forecasts;
    }

    @Override
    public String toString() {
        return "Forecasts{" +
                "forecasts=" + forecasts +
                '}';
    }

    public <ForecastDates> void setForecastDates(List<ForecastDates> dates) {
    }
}
