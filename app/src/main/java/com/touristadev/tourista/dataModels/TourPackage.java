package com.touristadev.tourista.dataModels;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 3/9/2017.
 */

public class TourPackage {
    public String packageId;
    public String packageName;
    public String travelAgencyId;
    public float payment;
    public int numOfTGNeeded;
    public float rating;
    public String description;
    public String duration;
    public int numOfSpots;
    public int minPeople;
    public String photoFileName;
    public String category;
    public ArrayList<SpotsPackage> spots;

    public static String PACKAGEID = "packageId";
    public static String PACKAGENAME = "packageName";
    public static String TRAVELAGENCYID = "travelAgencyId";
    public static String PAYMENT = "payment";
    public static String NUMOFTGNEEDED = "numOfTGNeeded";
    public static String RATING = "rating";
    public static String DESCRIPTION = "description";
    public static String DURATION = "duration";
    public static String NUMOFSPOTS = "numOfSpots";
    public static String MINPEOPLE = "minPeople";
    public static String PHOTOFILENAME = "photoPath";
    public static String CATEGORY = "category";
    public static String SPOTS = "spots";

    public TourPackage(String packageId, String packageName, String travelAgencyId, float payment, int numOfTGNeeded, float rating, String description, String duration, int numOfSpots, int minPeople, String photoFileName, String category) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.travelAgencyId = travelAgencyId;
        this.payment = payment;
        this.numOfTGNeeded = numOfTGNeeded;
        this.rating = rating;
        this.description = description;
        this.duration = duration;
        this.numOfSpots = numOfSpots;
        this.minPeople = minPeople;
        this.photoFileName = photoFileName;
        this.category = category;
    }

    public TourPackage(String packageId, String packageName, String travelAgencyId, float payment, int numOfTGNeeded, float rating, String description, String duration, int numOfSpots, int minPeople, String photoFileName, String category, ArrayList<SpotsPackage> spots) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.travelAgencyId = travelAgencyId;
        this.payment = payment;
        this.numOfTGNeeded = numOfTGNeeded;
        this.rating = rating;
        this.description = description;
        this.duration = duration;
        this.numOfSpots = numOfSpots;
        this.minPeople = minPeople;
        this.photoFileName = photoFileName;
        this.category = category;
        this.spots = spots;
    }

//    public TourPackage(String packageId, String packageName, String travelAgencyId, float payment, int numOfTGNeeded, float rating, String description, String duration, int numOfSpots, int minPeople, String photoFileName, String category){
//
//    }


    @Override
    public String toString() {
        return '{' +
                "packageId" + ":\"" + travelAgencyId + "\"" +
                "packageName" + ":\"" + packageName + "\"" +
                " travelAgencyId" + ":\"" + travelAgencyId + "\"" +
                "packageId" + ":\"" + travelAgencyId + "\"" +
                "payment" + ":\"" + payment + "\"" +
                "numOfTGNeeded" + ":\"" + numOfTGNeeded + "\"" +
                "rating" + ":\"" + rating + "\"" +
                "description" + ":\"" + description + "\"" +
                "duration" + ":\"" + duration + "\"" +
                "minPeople" + ":\"" + minPeople + "\"" +
                "photoFileName" + ":\"" + photoFileName + "\"" +
                "category" + ":\"" + category + "\"" +
                '}';
    }

    public TourPackage() {
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getTravelAgencyId() {
        return travelAgencyId;
    }

    public void setTravelAgencyId(String travelAgencyId) {
        this.travelAgencyId = travelAgencyId;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public int getNumOfTGNeeded() {
        return numOfTGNeeded;
    }

    public void setNumOfTGNeeded(int numOfTGNeeded) {
        this.numOfTGNeeded = numOfTGNeeded;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getNumOfSpots() {
        return numOfSpots;
    }

    public void setNumOfSpots(int numOfSpots) {
        this.numOfSpots = numOfSpots;
    }

    public int getMinPeople() {
        return minPeople;
    }

    public void setMinPeople(int minPeople) {
        this.minPeople = minPeople;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<SpotsPackage> getSpots() {
        return spots;
    }

    public void setSpots(ArrayList<SpotsPackage> spots) {
        this.spots = spots;
    }

    public static String getPACKAGEID() {
        return PACKAGEID;
    }

    public static void setPACKAGEID(String PACKAGEID) {
        TourPackage.PACKAGEID = PACKAGEID;
    }

    public static String getPACKAGENAME() {
        return PACKAGENAME;
    }

    public static void setPACKAGENAME(String PACKAGENAME) {
        TourPackage.PACKAGENAME = PACKAGENAME;
    }

    public static String getTRAVELAGENCYID() {
        return TRAVELAGENCYID;
    }

    public static void setTRAVELAGENCYID(String TRAVELAGENCYID) {
        TourPackage.TRAVELAGENCYID = TRAVELAGENCYID;
    }

    public static String getPAYMENT() {
        return PAYMENT;
    }

    public static void setPAYMENT(String PAYMENT) {
        TourPackage.PAYMENT = PAYMENT;
    }

    public static String getNUMOFTGNEEDED() {
        return NUMOFTGNEEDED;
    }

    public static void setNUMOFTGNEEDED(String NUMOFTGNEEDED) {
        TourPackage.NUMOFTGNEEDED = NUMOFTGNEEDED;
    }

    public static String getRATING() {
        return RATING;
    }

    public static void setRATING(String RATING) {
        TourPackage.RATING = RATING;
    }

    public static String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public static void setDESCRIPTION(String DESCRIPTION) {
        TourPackage.DESCRIPTION = DESCRIPTION;
    }

    public static String getDURATION() {
        return DURATION;
    }

    public static void setDURATION(String DURATION) {
        TourPackage.DURATION = DURATION;
    }

    public static String getNUMOFSPOTS() {
        return NUMOFSPOTS;
    }

    public static void setNUMOFSPOTS(String NUMOFSPOTS) {
        TourPackage.NUMOFSPOTS = NUMOFSPOTS;
    }

    public static String getMINPEOPLE() {
        return MINPEOPLE;
    }

    public static void setMINPEOPLE(String MINPEOPLE) {
        TourPackage.MINPEOPLE = MINPEOPLE;
    }

    public static String getPHOTOFILENAME() {
        return PHOTOFILENAME;
    }

    public static void setPHOTOFILENAME(String PHOTOFILENAME) {
        TourPackage.PHOTOFILENAME = PHOTOFILENAME;
    }

    public static String getCATEGORY() {
        return CATEGORY;
    }

    public static void setCATEGORY(String CATEGORY) {
        TourPackage.CATEGORY = CATEGORY;
    }

    public static String getSPOTS() {
        return SPOTS;
    }

    public static void setSPOTS(String SPOTS) {
        TourPackage.SPOTS = SPOTS;
    }
}