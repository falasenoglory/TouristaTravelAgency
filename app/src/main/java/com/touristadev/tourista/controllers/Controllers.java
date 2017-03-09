package com.touristadev.tourista.controllers;

import com.google.firebase.auth.FirebaseUser;
import com.touristadev.tourista.dataModels.BookedPackage;
import com.touristadev.tourista.dataModels.TourGuide;
import com.touristadev.tourista.dataModels.TourRequest;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 11/27/2016.
 */

public class Controllers {

    public static FirebaseUser user;
    public static String currentUser;
    public static TourGuide CurrentGT = new TourGuide();
    public static String CurrentUserAuthenticationUrl="http://192.168.254.100:8000/api/authenticate";
    public static String TGGetRequestUrl="http://192.168.254.100:8000/api/get/tour/guide/package?guideId="; // for fetching packages
    public static String TGBookedAcceptUrl="http://192.168.254.100:8000/api/confirm/by/tour/guide="; // for confirm or reject
    public static String TGCancelRequestUrl="http://192.168.254.100:8000/api/cancel/guide/transaction=";
    public static String TGEndToourUrl="http://192.168.254.100:8000/api/end/tour";
    public static String GETallSpotsUrl="http://192.168.254.100:8000/api/get/all/spots";
    public static String CreateTGUrl="http://192.168.254.100:8000/api/create-user";
    public static ArrayList<TourRequest> TourRequestList= new ArrayList<>();
    public static ArrayList<BookedPackage> TourBookedList= new ArrayList<>();
    public static ArrayList<BookedPackage> HistoryList= new ArrayList<>();
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