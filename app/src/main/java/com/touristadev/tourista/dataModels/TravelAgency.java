package com.touristadev.tourista.dataModels;

/**
 * Created by Eugene Boholst on 3/9/2017.
 */

public class TravelAgency {
    public String travelAgencyId;
    public String agencyName;
    public String streetAddress;
    public String city;
    public String country;
    public String zipCode;
    public String contactNumber;
    public String email;
    public String password;
    public static String TRAVELAGENCYID = "travelAgencyId";
    public static String AGENCYNAME = "agencyName";
    public static String STREETADDRESS = "streetAddress";
    public static String CITY = "city";
    public static String COUNTRY = "country";
    public static String ZIPCODE = "zipCode";
    public static String CONTACTNUMBER = "contactNumber";
    public static String EMAIL = "email";
    public static String PASSWORD = "password";


    public TravelAgency() {
    }

    public TravelAgency(String agencyName, String streetAddress, String city, String country, String zipCode, String contactNumber, String email, String password) {
        this.agencyName = agencyName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.contactNumber = contactNumber;
        this.email = email;
        this.password = password;
    }

    public TravelAgency(String travelAgencyId, String agencyName, String streetAddress, String city, String country, String zipCode, String contactNumber, String email, String password) {
        this.travelAgencyId = travelAgencyId;
        this.agencyName = agencyName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.contactNumber = contactNumber;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
                "travelAgencyId" + ":\"" + travelAgencyId + "\"" +
                ", agencyName" + ":\""  + agencyName + ":\""  +
                ", streetAddress" + ":\""  + streetAddress  + ":\""  +
                ", city"  + ":\"" + city  + ":\""  +
                ", country"  + ":\"" + country  + ":\""  +
                ", zipCode"  + ":\"" + zipCode  + ":\""  +
                ", contactNumber"  + ":\"" + contactNumber  + ":\""  +
                ", email"  + ":\"" + email  + ":\""  +
                ", password"  + ":\"" + password  + "\""  +
                '}';
    }


}
