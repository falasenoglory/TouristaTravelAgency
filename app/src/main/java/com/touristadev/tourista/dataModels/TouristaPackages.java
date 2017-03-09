package com.touristadev.tourista.dataModels;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 11/26/2016.
 */

public class TouristaPackages {
    private String packageId;
    private String packageName;
    private ArrayList<Itinerary> packageItinerary;
    private String packageTourGuideClassification;
    private double rating;
    private int packageNoOfSpots;
    private int packageTotalNoOfHours;
    private String packageImage;
    private ArrayList<Spots > spotItinerary= new ArrayList<>();
    private String packDescription;
    private String packPrice;
    private String CompanyName;
    private String transactionId;
    public TouristaPackages() {
    }

    public TouristaPackages(String packageId, String packageName, ArrayList<Itinerary> packageItinerary, String packageTourGuideClassification, double rating, int packageNoOfSpots, int packageTotalNoOfHours, String packageImage, ArrayList<Spots> spotItinerary, String packDescription, String packPrice, String companyName, String transactionId) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.packageItinerary = packageItinerary;
        this.packageTourGuideClassification = packageTourGuideClassification;
        this.rating = rating;
        this.packageNoOfSpots = packageNoOfSpots;
        this.packageTotalNoOfHours = packageTotalNoOfHours;
        this.packageImage = packageImage;
        this.spotItinerary = spotItinerary;
        this.packDescription = packDescription;
        this.packPrice = packPrice;
        CompanyName = companyName;
        this.transactionId = transactionId;
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

    public ArrayList<Itinerary> getPackageItinerary() {
        return packageItinerary;
    }

    public void setPackageItinerary(ArrayList<Itinerary> packageItinerary) {
        this.packageItinerary = packageItinerary;
    }

    public String getPackageTourGuideClassification() {
        return packageTourGuideClassification;
    }

    public void setPackageTourGuideClassification(String packageTourGuideClassification) {
        this.packageTourGuideClassification = packageTourGuideClassification;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPackageNoOfSpots() {
        return packageNoOfSpots;
    }

    public void setPackageNoOfSpots(int packageNoOfSpots) {
        this.packageNoOfSpots = packageNoOfSpots;
    }

    public int getPackageTotalNoOfHours() {
        return packageTotalNoOfHours;
    }

    public void setPackageTotalNoOfHours(int packageTotalNoOfHours) {
        this.packageTotalNoOfHours = packageTotalNoOfHours;
    }

    public String getPackageImage() {
        return packageImage;
    }

    public void setPackageImage(String packageImage) {
        this.packageImage = packageImage;
    }

    public ArrayList<Spots> getSpotItinerary() {
        return spotItinerary;
    }

    public void setSpotItinerary(ArrayList<Spots> spotItinerary) {
        this.spotItinerary = spotItinerary;
    }

    public String getPackDescription() {
        return packDescription;
    }

    public void setPackDescription(String packDescription) {
        this.packDescription = packDescription;
    }

    public String getPackPrice() {
        return packPrice;
    }

    public void setPackPrice(String packPrice) {
        this.packPrice = packPrice;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}