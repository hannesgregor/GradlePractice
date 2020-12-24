package com.weather.models;

import java.util.List;

public class Night {

    private String phenomenon;
    private int tempmin;
    private int tempmax;
    private String text;
    private List<Place> places;

    public Night(String phenomenon, int tempmin, int tempmax, String textContent, String text) {
        this.phenomenon = phenomenon;
        this.tempmin = tempmin;
        this.tempmax = tempmax;
        this.text = text;
    }

    public String getPhenomenon() {
        return phenomenon;
    }

    public void setPhenomenon(String phenomenon) {
        this.phenomenon = phenomenon;
    }

    public int getTempmin() {
        return tempmin;
    }

    public void setTempmin(int tempmin) {
        this.tempmin = tempmin;
    }

    public int getTempmax() {
        return tempmax;
    }

    public void setTempmax(int tempmax) {
        this.tempmax = tempmax;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "Night{" +
                "phenomenon='" + phenomenon + '\'' +
                ", tempmin=" + tempmin +
                ", tempmax=" + tempmax +
                ", text='" + text + '\'' +
                ", places=" + places +
                '}';
    }
}
