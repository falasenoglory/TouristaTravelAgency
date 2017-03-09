package com.touristadev.tourista.dataModels;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 12/15/2016.
 */

public class TourGuide {

    private String TGFirebaseId; // firebaseID
    private String TGfacebookId;
    private String TGGuideID;
    private String TGEmail;
    private String TGPhotoUrl;

    private String TGfirstName;
    private String TGMiddleName;
    private String TGlastName;
    private String TGProfileDescription;


    private String TGcellphoneNumber;
    private String TGdateOfBirth;
    private String TGcitizenship;

    private String TGCity;
    private String TGStreedAddress;
    private String TGCounty;
    private String TGZipCode;

    private double GenAllRating;
    private double GenAcceptanceRating;
    private ArrayList<String> TGLanguages;
    private double actsProfessionally;
    private double isKnowledgeable;
    private double hasTheRightPersonality;
    private int TGcountPriority;

    private String TGCreditCardEmail;
    private String TGCreditCardPassword;
    private String TGCreditCardNo;
    private String TGCreditExpiryMo;
    private String TGCreditExpiryYr;
    private String TGCreditExpiryDay;
    private String TGCreditCVV;

    public TourGuide() {
    }

    public TourGuide(String TGFirebaseId, String TGfacebookId, String TGGuideID, String TGEmail, String TGPhotoUrl, String TGfirstName, String TGMiddleName, String TGlastName, String TGProfileDescription, String TGcellphoneNumber, String TGdateOfBirth, String TGcitizenship, String TGCity, String TGStreedAddress, String TGCounty, String TGZipCode, double genAllRating, double genAcceptanceRating, ArrayList<String> TGLanguages, double actsProfessionally, double isKnowledgeable, double hasTheRightPersonality, int TGcountPriority, String TGCreditCardEmail, String TGCreditCardPassword, String TGCreditCardNo, String TGCreditExpiryMo, String TGCreditExpiryYr, String TGCreditExpiryDay, String TGCreditCVV) {
        this.TGFirebaseId = TGFirebaseId;
        this.TGfacebookId = TGfacebookId;
        this.TGGuideID = TGGuideID;
        this.TGEmail = TGEmail;
        this.TGPhotoUrl = TGPhotoUrl;
        this.TGfirstName = TGfirstName;
        this.TGMiddleName = TGMiddleName;
        this.TGlastName = TGlastName;
        this.TGProfileDescription = TGProfileDescription;
        this.TGcellphoneNumber = TGcellphoneNumber;
        this.TGdateOfBirth = TGdateOfBirth;
        this.TGcitizenship = TGcitizenship;
        this.TGCity = TGCity;
        this.TGStreedAddress = TGStreedAddress;
        this.TGCounty = TGCounty;
        this.TGZipCode = TGZipCode;
        GenAllRating = genAllRating;
        GenAcceptanceRating = genAcceptanceRating;
        this.TGLanguages = TGLanguages;
        this.actsProfessionally = actsProfessionally;
        this.isKnowledgeable = isKnowledgeable;
        this.hasTheRightPersonality = hasTheRightPersonality;
        this.TGcountPriority = TGcountPriority;
        this.TGCreditCardEmail = TGCreditCardEmail;
        this.TGCreditCardPassword = TGCreditCardPassword;
        this.TGCreditCardNo = TGCreditCardNo;
        this.TGCreditExpiryMo = TGCreditExpiryMo;
        this.TGCreditExpiryYr = TGCreditExpiryYr;
        this.TGCreditExpiryDay = TGCreditExpiryDay;
        this.TGCreditCVV = TGCreditCVV;
    }

    public String getTGFirebaseId() {
        return TGFirebaseId;
    }

    public void setTGFirebaseId(String TGFirebaseId) {
        this.TGFirebaseId = TGFirebaseId;
    }

    public String getTGfacebookId() {
        return TGfacebookId;
    }

    public void setTGfacebookId(String TGfacebookId) {
        this.TGfacebookId = TGfacebookId;
    }

    public String getTGGuideID() {
        return TGGuideID;
    }

    public void setTGGuideID(String TGGuideID) {
        this.TGGuideID = TGGuideID;
    }

    public String getTGEmail() {
        return TGEmail;
    }

    public void setTGEmail(String TGEmail) {
        this.TGEmail = TGEmail;
    }

    public String getTGPhotoUrl() {
        return TGPhotoUrl;
    }

    public void setTGPhotoUrl(String TGPhotoUrl) {
        this.TGPhotoUrl = TGPhotoUrl;
    }

    public String getTGfirstName() {
        return TGfirstName;
    }

    public void setTGfirstName(String TGfirstName) {
        this.TGfirstName = TGfirstName;
    }

    public String getTGMiddleName() {
        return TGMiddleName;
    }

    public void setTGMiddleName(String TGMiddleName) {
        this.TGMiddleName = TGMiddleName;
    }

    public String getTGlastName() {
        return TGlastName;
    }

    public void setTGlastName(String TGlastName) {
        this.TGlastName = TGlastName;
    }

    public String getTGProfileDescription() {
        return TGProfileDescription;
    }

    public void setTGProfileDescription(String TGProfileDescription) {
        this.TGProfileDescription = TGProfileDescription;
    }

    public String getTGcellphoneNumber() {
        return TGcellphoneNumber;
    }

    public void setTGcellphoneNumber(String TGcellphoneNumber) {
        this.TGcellphoneNumber = TGcellphoneNumber;
    }

    public String getTGdateOfBirth() {
        return TGdateOfBirth;
    }

    public void setTGdateOfBirth(String TGdateOfBirth) {
        this.TGdateOfBirth = TGdateOfBirth;
    }

    public String getTGcitizenship() {
        return TGcitizenship;
    }

    public void setTGcitizenship(String TGcitizenship) {
        this.TGcitizenship = TGcitizenship;
    }

    public String getTGCity() {
        return TGCity;
    }

    public void setTGCity(String TGCity) {
        this.TGCity = TGCity;
    }

    public String getTGStreedAddress() {
        return TGStreedAddress;
    }

    public void setTGStreedAddress(String TGStreedAddress) {
        this.TGStreedAddress = TGStreedAddress;
    }

    public String getTGCounty() {
        return TGCounty;
    }

    public void setTGCounty(String TGCounty) {
        this.TGCounty = TGCounty;
    }

    public String getTGZipCode() {
        return TGZipCode;
    }

    public void setTGZipCode(String TGZipCode) {
        this.TGZipCode = TGZipCode;
    }

    public double getGenAllRating() {
        return GenAllRating;
    }

    public void setGenAllRating(double genAllRating) {
        GenAllRating = genAllRating;
    }

    public double getGenAcceptanceRating() {
        return GenAcceptanceRating;
    }

    public void setGenAcceptanceRating(double genAcceptanceRating) {
        GenAcceptanceRating = genAcceptanceRating;
    }

    public ArrayList<String> getTGLanguages() {
        return TGLanguages;
    }

    public void setTGLanguages(ArrayList<String> TGLanguages) {
        this.TGLanguages = TGLanguages;
    }

    public double getActsProfessionally() {
        return actsProfessionally;
    }

    public void setActsProfessionally(double actsProfessionally) {
        this.actsProfessionally = actsProfessionally;
    }

    public double getIsKnowledgeable() {
        return isKnowledgeable;
    }

    public void setIsKnowledgeable(double isKnowledgeable) {
        this.isKnowledgeable = isKnowledgeable;
    }

    public double getHasTheRightPersonality() {
        return hasTheRightPersonality;
    }

    public void setHasTheRightPersonality(double hasTheRightPersonality) {
        this.hasTheRightPersonality = hasTheRightPersonality;
    }

    public int getTGcountPriority() {
        return TGcountPriority;
    }

    public void setTGcountPriority(int TGcountPriority) {
        this.TGcountPriority = TGcountPriority;
    }

    public String getTGCreditCardEmail() {
        return TGCreditCardEmail;
    }

    public void setTGCreditCardEmail(String TGCreditCardEmail) {
        this.TGCreditCardEmail = TGCreditCardEmail;
    }

    public String getTGCreditCardPassword() {
        return TGCreditCardPassword;
    }

    public void setTGCreditCardPassword(String TGCreditCardPassword) {
        this.TGCreditCardPassword = TGCreditCardPassword;
    }

    public String getTGCreditCardNo() {
        return TGCreditCardNo;
    }

    public void setTGCreditCardNo(String TGCreditCardNo) {
        this.TGCreditCardNo = TGCreditCardNo;
    }

    public String getTGCreditExpiryMo() {
        return TGCreditExpiryMo;
    }

    public void setTGCreditExpiryMo(String TGCreditExpiryMo) {
        this.TGCreditExpiryMo = TGCreditExpiryMo;
    }

    public String getTGCreditExpiryYr() {
        return TGCreditExpiryYr;
    }

    public void setTGCreditExpiryYr(String TGCreditExpiryYr) {
        this.TGCreditExpiryYr = TGCreditExpiryYr;
    }

    public String getTGCreditExpiryDay() {
        return TGCreditExpiryDay;
    }

    public void setTGCreditExpiryDay(String TGCreditExpiryDay) {
        this.TGCreditExpiryDay = TGCreditExpiryDay;
    }

    public String getTGCreditCVV() {
        return TGCreditCVV;
    }

    public void setTGCreditCVV(String TGCreditCVV) {
        this.TGCreditCVV = TGCreditCVV;
    }
}

