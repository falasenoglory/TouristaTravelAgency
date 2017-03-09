package com.touristadev.tourista.dataModels;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 2/6/2017.
 */

public class BookedPackage {

    private String tourTransactionId;
    private String description;
    private String status;
    private int numOfPeople;
    private String agencyName;
    private String photoPath;
    private String TGPayment;
    private String numOfSpots;
    private String price;
    private String touristName;
    private String packageId;
    private String tourDate;
    private String userId;
    private String packageName;
    private String reserveDate;
    private int rating;
    private String type;

    private ArrayList<Itinerary> itenerary_details;

    public BookedPackage() {
    }

    public BookedPackage(String tourTransactionId, String description, String status, int numOfPeople, String agencyName, String photoPath, String TGPayment, String numOfSpots, String price, String touristName, String packageId, String tourDate, String userId, String packageName, String reserveDate, int rating, String type, ArrayList<Itinerary> itenerary_details) {
        this.tourTransactionId = tourTransactionId;
        this.description = description;
        this.status = status;
        this.numOfPeople = numOfPeople;
        this.agencyName = agencyName;
        this.photoPath = photoPath;
        this.TGPayment = TGPayment;
        this.numOfSpots = numOfSpots;
        this.price = price;
        this.touristName = touristName;
        this.packageId = packageId;
        this.tourDate = tourDate;
        this.userId = userId;
        this.packageName = packageName;
        this.reserveDate = reserveDate;
        this.rating = rating;
        this.type = type;
        this.itenerary_details = itenerary_details;
    }

    public String getTourTransactionId() {
        return tourTransactionId;
    }

    public void setTourTransactionId(String tourTransactionId) {
        this.tourTransactionId = tourTransactionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getTGPayment() {
        return TGPayment;
    }

    public void setTGPayment(String TGPayment) {
        this.TGPayment = TGPayment;
    }

    public String getNumOfSpots() {
        return numOfSpots;
    }

    public void setNumOfSpots(String numOfSpots) {
        this.numOfSpots = numOfSpots;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTouristName() {
        return touristName;
    }

    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getTourDate() {
        return tourDate;
    }

    public void setTourDate(String tourDate) {
        this.tourDate = tourDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(String reserveDate) {
        this.reserveDate = reserveDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Itinerary> getItenerary_details() {
        return itenerary_details;
    }

    public void setItenerary_details(ArrayList<Itinerary> itenerary_details) {
        this.itenerary_details = itenerary_details;
    }
}
