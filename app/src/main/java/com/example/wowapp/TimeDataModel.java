package com.example.wowapp;

public class TimeDataModel {
    private String countrySymbol;
    private String countryName;
    private int hoursAhead;
    private boolean isSelected;

    public TimeDataModel(String countryName, String countrySymbol, int hoursAhead, boolean isSelected) {
        this.countrySymbol = countrySymbol;
        this.countryName = countryName;
        this.hoursAhead = hoursAhead;
        this.isSelected = isSelected;
    }

    public String getCountrySymbol() {
        return countrySymbol;
    }

    public void setCountrySymbol(String countrySymbol) {
        this.countrySymbol = countrySymbol;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getHoursAhead() {
        return hoursAhead;
    }

    public void setHoursAhead(int hoursAhead) {
        this.hoursAhead = hoursAhead;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
