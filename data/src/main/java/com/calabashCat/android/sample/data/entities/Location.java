package com.calabashCat.android.sample.data.entities;

import java.util.List;

public class Location {
    private String cross_streets;
    private String city;
    private double geo_accuracy;
    private String postal_code;
    private String country_code;
    /**
     * latitude : 37.7810450986458
     * longitude : -122.395337771053
     */

    private Coordinate coordinate;
    private String state_code;
    private List<String> display_address;
    private List<String> neighborhoods;
    private List<String> address;

    public void setCross_streets(String cross_streets) {
        this.cross_streets = cross_streets;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setGeo_accuracy(double geo_accuracy) {
        this.geo_accuracy = geo_accuracy;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public void setDisplay_address(List<String> display_address) {
        this.display_address = display_address;
    }

    public void setNeighborhoods(List<String> neighborhoods) {
        this.neighborhoods = neighborhoods;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public String getCross_streets() {
        return cross_streets;
    }

    public String getCity() {
        return city;
    }

    public double getGeo_accuracy() {
        return geo_accuracy;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getCountry_code() {
        return country_code;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getState_code() {
        return state_code;
    }

    public List<String> getDisplay_address() {
        return display_address;
    }

    public List<String> getNeighborhoods() {
        return neighborhoods;
    }

    public List<String> getAddress() {
        return address;
    }
}
