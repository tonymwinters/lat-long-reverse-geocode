package com.tw.models;

import java.util.Date;

/**
 * Created by tonywinters on 2/24/17.
 */
public class LatLongRequest {

    private double latitude;
    private double longitude;
    private String address;
    private Date dateRequested;

    public LatLongRequest(double latitude, double longitude, String address, Date dateRequested) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.dateRequested = dateRequested;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }
}
