package com.dream.searchit.models;

import java.io.Serializable;

/**
 * Created by Dream on 10/24/2017.
 */

public class Contact_info implements Serializable {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String name;
    private Long number;
    private String address;
    private double lat;
    private double lng;


    public Contact_info(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }







    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Contact_info(String name, Long number, String address) {
        this.name = name;
        this.number = number;
        this.address = address;
    }



    public Contact_info() {
    }
}
