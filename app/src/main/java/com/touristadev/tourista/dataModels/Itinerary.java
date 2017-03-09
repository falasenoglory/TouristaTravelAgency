package com.touristadev.tourista.dataModels;

/**
 * Created by Shanyl Jimenez on 11/26/2016.
 */

public class Itinerary {

    private int chronology;
    private String spotPhotoFileName;
    private String spotId;
    private String startTime;
    private String spotName;
    private String LATITUDE;
    private String endTime;
    private String LONGITUDE;
    private String description;

    public Itinerary() {
    }

    public Itinerary(int chronology, String spotPhotoFileName, String spotId, String startTime, String spotName, String LATITUDE, String endTime, String LONGITUDE, String description) {
        this.chronology = chronology;
        this.spotPhotoFileName = spotPhotoFileName;
        this.spotId = spotId;
        this.startTime = startTime;
        this.spotName = spotName;
        this.LATITUDE = LATITUDE;
        this.endTime = endTime;
        this.LONGITUDE = LONGITUDE;
        this.description = description;
    }

    public int getChronology() {
        return chronology;
    }

    public void setChronology(int chronology) {
        this.chronology = chronology;
    }

    public String getSpotPhotoFileName() {
        return spotPhotoFileName;
    }

    public void setSpotPhotoFileName(String spotPhotoFileName) {
        this.spotPhotoFileName = spotPhotoFileName;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getLATITUDE() {
        return LATITUDE;
    }

    public void setLATITUDE(String LATITUDE) {
        this.LATITUDE = LATITUDE;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLONGITUDE() {
        return LONGITUDE;
    }

    public void setLONGITUDE(String LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
