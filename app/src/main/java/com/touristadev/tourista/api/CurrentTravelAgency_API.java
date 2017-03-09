package com.touristadev.tourista.api;

import com.touristadev.tourista.dataModels.TravelAgency;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Shanyl Jimenez on 3/9/2017.
 */

public final class CurrentTravelAgency_API {
    public static String travelAgencyId;
    public static String agencyName;
    public static String streetAddress;
    public static String city;
    public static String country;
    public static String zipCode;
    public static String contactNumber;
    public static String email;
    public static String password;

    public static void setTravelAgency(JSONObject jsonObject) {
        try {
            travelAgencyId = jsonObject.getString(TravelAgency.TRAVELAGENCYID);
            agencyName = jsonObject.getString(TravelAgency.AGENCYNAME);
            streetAddress = jsonObject.getString(TravelAgency.STREETADDRESS);
            city = jsonObject.getString(TravelAgency.CITY);
            country = jsonObject.getString(TravelAgency.COUNTRY);
            zipCode = jsonObject.getString(TravelAgency.ZIPCODE);
            contactNumber = jsonObject.getString(TravelAgency.CONTACTNUMBER);
            email = jsonObject.getString(TravelAgency.EMAIL);
//            password = jsonObject.getString(TravelAgency.PASSWORD);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
