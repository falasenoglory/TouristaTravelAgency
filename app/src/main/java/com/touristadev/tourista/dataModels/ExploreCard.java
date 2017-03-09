package com.touristadev.tourista.dataModels;

/**
 * Created by Christian on 11/25/2016.
 */

public class ExploreCard {
    private String Title;
    private double Rating;
    private String Price;
    private String NoSpots;
    private String NoHours; //Date
    private String type;
    private String imgView;
    private String CompanyName;

    public ExploreCard(String title, double rating, String price, String noSpots, String noHours, String type, String imgView, String companyName) {
        Title = title;
        Rating = rating;
        Price = price;
        NoSpots = noSpots;
        NoHours = noHours;
        this.type = type;
        this.imgView = imgView;
        CompanyName = companyName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getNoSpots() {
        return NoSpots;
    }

    public void setNoSpots(String noSpots) {
        NoSpots = noSpots;
    }

    public String getNoHours() {
        return NoHours;
    }

    public void setNoHours(String noHours) {
        NoHours = noHours;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgView() {
        return imgView;
    }

    public void setImgView(String imgView) {
        this.imgView = imgView;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }
}
