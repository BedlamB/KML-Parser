package com.example;

/**
 * Created by IntelliJ IDEA.
 * User: vicks
 * Date: 07/04/2012
 * Time: 20:16
 * To change this template use File | Settings | File Templates.
 */
public class Location {
    Double lat, lon;


    public Location(Double l){
        this.lat = l;

    }
    public Location(Double lat, Double lon){
        this.lat = lat;
        this.lon = lon;
        
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
