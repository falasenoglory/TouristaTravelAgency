package com.touristadev.tourista.dataModels;

/**
 * Created by Shanyl Jimenez on 3/9/2017.
 */

public class SpotsPackage {
    public String packageId;
    public String LONGITUDE;
    public int chronology;
    public String spotId;
    public String startTime;
    public String photoFileName;
    public String description;
    public String spotName;
    public String hours;
    public String LATITUDE;
    public String endTime;

    public static String PACKAGEID = "packageId";
    public static String sLONGITUDE = "LONGITUDE";
    public static String CHRONOLOGY = "chronology";
    public static String SPOTID = "spotId";
    public static String STARTTIME = "startTime";
    public static String PHOTOFILENAME = "photoFileName";
    public static String DESCRIPTION = "description";
    public static String SPOTNAME = "spotName";
    public static String HOURS = "hours";
    public static String sLATITUDE = "LATITUDE";
    public static String ENDTIME = "endTime";

    public SpotsPackage(String packageId, String LONGITUDE, int chronology, String spotId, String startTime, String photoFileName, String description, String spotName, String hours, String LATITUDE, String endTime) {
        this.packageId = packageId;
        this.LONGITUDE = LONGITUDE;
        this.chronology = chronology;
        this.spotId = spotId;
        this.startTime = startTime;
        this.photoFileName = photoFileName;
        this.description = description;
        this.spotName = spotName;
        this.hours = hours;
        this.LATITUDE = LATITUDE;
        this.endTime = endTime;
    }
}
