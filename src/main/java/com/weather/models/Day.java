package com.weather.models;

import java.util.List;

public class Day {

    private String phenomenon;
    private int tempmin;
    private int tempmax;
    private String text;
    private List<Place> places;

    public Day(String phenomenon, int tempmin, int tempmax, String textContent, String text) {
        this.phenomenon = phenomenon;
        this.tempmin = tempmin;
        this.tempmax = tempmax;
        this.text = text;
    }

    public void setPlaces(List<Place> places) {
    }
}
