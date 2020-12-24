package com.weather.models;

import java.util.List;

public class Place {

    private int tempMin;
    private String phenomenon;
    private String name;

    public Place(int tempMin, String phenomenon, String name) {
        this.tempMin = tempMin;
        this.phenomenon = phenomenon;
        this.name = name;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int id) {
        this.tempMin = tempMin;
    }

    public String getPhenomenon() {
        return phenomenon;
    }

    public void setPhenomenon(String phenomenon) {
        this.phenomenon = phenomenon;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Place{" +
                "tempMin=" + tempMin +
                ", phenomenon='" + phenomenon + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}