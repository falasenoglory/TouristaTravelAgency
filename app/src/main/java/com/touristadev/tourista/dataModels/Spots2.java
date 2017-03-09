package com.touristadev.tourista.dataModels;

/**
 * Created by Christian on 3/9/2017.
 */

public class Spots2
{
    private String spotID;
    private String spotName;
    private String spotAddress;
    private String spotOpeningTime;
    private String spotClosingTime;
    private String spotDescription;
    private String spotLocationLong;
    private String spotLocationLat;
    private int spotRating;
    private String spotImage;
    private String city;
    private String hours;
    public Spots2() {
    }

    public Spots2(String spotID, String spotName, String spotAddress, String spotOpeningTime, String spotClosingTime, String spotDescription, String spotLocationLong, String spotLocationLat, int spotRating, String spotImage, String city, String hours) {
        this.spotID = spotID;
        this.spotName = spotName;
        this.spotAddress = spotAddress;
        this.spotOpeningTime = spotOpeningTime;
        this.spotClosingTime = spotClosingTime;
        this.spotDescription = spotDescription;
        this.spotLocationLong = spotLocationLong;
        this.spotLocationLat = spotLocationLat;
        this.spotRating = spotRating;
        this.spotImage = spotImage;
        this.city = city;
        this.hours = hours;
    }

    public String getSpotID() {
        return spotID;
    }

    public void setSpotID(String spotID) {
        this.spotID = spotID;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getSpotAddress() {
        return spotAddress;
    }

    public void setSpotAddress(String spotAddress) {
        this.spotAddress = spotAddress;
    }

    public String getSpotOpeningTime() {
        return spotOpeningTime;
    }

    public void setSpotOpeningTime(String spotOpeningTime) {
        this.spotOpeningTime = spotOpeningTime;
    }

    public String getSpotClosingTime() {
        return spotClosingTime;
    }

    public void setSpotClosingTime(String spotClosingTime) {
        this.spotClosingTime = spotClosingTime;
    }

    public String getSpotDescription() {
        return spotDescription;
    }

    public void setSpotDescription(String spotDescription) {
        this.spotDescription = spotDescription;
    }

    public String getSpotLocationLong() {
        return spotLocationLong;
    }

    public void setSpotLocationLong(String spotLocationLong) {
        this.spotLocationLong = spotLocationLong;
    }

    public String getSpotLocationLat() {
        return spotLocationLat;
    }

    public void setSpotLocationLat(String spotLocationLat) {
        this.spotLocationLat = spotLocationLat;
    }

    public int getSpotRating() {
        return spotRating;
    }

    public void setSpotRating(int spotRating) {
        this.spotRating = spotRating;
    }

    public String getSpotImage() {
        return spotImage;
    }

    public void setSpotImage(String spotImage) {
        this.spotImage = spotImage;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}


