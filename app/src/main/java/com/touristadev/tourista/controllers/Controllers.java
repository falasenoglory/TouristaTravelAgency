package com.touristadev.tourista.controllers;

import com.google.firebase.auth.FirebaseUser;
import com.touristadev.tourista.dataModels.BookedPackage;
import com.touristadev.tourista.dataModels.TourGuide;
import com.touristadev.tourista.dataModels.TourPackage;
import com.touristadev.tourista.dataModels.TourRequest;
import com.touristadev.tourista.dataModels.TravelAgency;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 11/27/2016.
 */

public class Controllers {


    //////////////////////////////////////////////////////////////////////////////////////////////////
    public static String URL = "http://192.168.254.101:8000";
    public static FirebaseUser user;
    public static String currentUser;
    public static TourGuide CurrentGT = new TourGuide();
    public static String CurrentUserAuthenticationUrl= URL + "/api/authenticate";
    public static String TGGetRequestUrl= URL + "/api/get/tour/guide/package?guideId="; // for fetching packages
    public static String TGBookedAcceptUrl= URL + "/api/confirm/by/tour/guide="; // for confirm or reject
    public static String TGCancelRequestUrl= URL + "/api/cancel/guide/transaction=";
    public static String TGEndTourUrl= URL + "/api/end/tour";
    //////////////////////////////////////////////////////////////////////////////////////////////////

    public static TravelAgency CurrentTA= new TravelAgency();
    public static String GETallSpotsUrl= URL + "/api/get/all/spots";
    public static String GET_TG_PACKAGES = URL + "/api/get/agency/package?agencyId=";
    public static String GETallRequestUrl= URL + "/api/get/agency/transactions?agencyId=";
    public static String CreateTGUrl= URL + "/api/create-user";
    public static String CREATE_TRAVEL_AGENCY_URL =  URL + "/api/create/travel/agency";


    public static ArrayList<TourRequest> TourRequestList= new ArrayList<>();
    public static ArrayList<BookedPackage> TourBookedList= new ArrayList<>();
    public static ArrayList<BookedPackage> HistoryList= new ArrayList<>();
    public static ArrayList<TourPackage> PackageList= new ArrayList<>();
    private static double referralPoints = 0,temppoints =0;
    public static int bookedposition;
    public static int requestposition;
    public static String response;


    public static void Controllers() {
    }

    public static double getReferralPoints(){
        return referralPoints;

    }
    public static void setReferralPoints(double ref){
        referralPoints = ref;

    }
    public static void setResponse(String response1){
        response = response1;

    }
    public static String Getresponse(){
        return response;

    }
    public static void temppoints(double ref){
        temppoints = ref;

    }
    public static double gettemppoints(){
        return temppoints;

    }

}