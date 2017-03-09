package com.touristadev.tourista.controllers;

import android.os.AsyncTask;
import android.util.Log;

import com.google.firebase.auth.FirebaseUser;
import com.touristadev.tourista.dataModels.BookedPackage;
import com.touristadev.tourista.dataModels.Spots;
import com.touristadev.tourista.dataModels.Spots2;
import com.touristadev.tourista.dataModels.TourGuide;
import com.touristadev.tourista.dataModels.TourPackage;
import com.touristadev.tourista.dataModels.TourRequest;
import com.touristadev.tourista.dataModels.TouristaPackages;
import com.touristadev.tourista.dataModels.TravelAgency;
import com.touristadev.tourista.utils.HttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Shanyl Jimenez on 11/27/2016.
 */

public class Controllers {


    //////////////////////////////////////////////////////////////////////////////////////////////////
    public static String URL = "http://192.168.1.5:8000";
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
    public static int packageposition;
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
    private static String finurl = "http://192.168.254.101:8000/";
    private static ArrayList<Spots2> finalSpotList = new ArrayList<>();
    private static ArrayList<Spots2> spotIt3 = new ArrayList<>();
    private static ArrayList<TouristaPackages> myTours = new ArrayList<>();
    public static void postToDb(String url , JSONObject obj){
        HttpUtils.POST(finurl+""+url,obj);
    }
//    static class GetWishList extends AsyncTask<Void, Void, ArrayList<TouristaPackages>> {
//
//        ArrayList<Itinerary> itineraries4 = new ArrayList<>();
//
//        @Override
//        protected ArrayList<TouristaPackages> doInBackground(Void... voids) {
//            Controllers con = new Controllers();
//
//            TouristaPackages tourTemp = new TouristaPackages();
//            try {
////                JSONArray json = new JSONArray(HttpUtils.GET(finurl+"api/get-booked-tours?userId="+CurrentUser.userFirebaseId+"&status=Request"));
//
//                for (int n = 0; n < json.length(); n++) {
//                    JSONObject object = json.getJSONObject(n);
//                    ArrayList<Spots> tempSpots = new ArrayList<>();
//                    tempSpots = finalSpotList;
//                    spotIt3.clear();
//                    JSONArray jarray = object.getJSONArray("itineraries");
//
//                    itineraries4.clear();
//                    for (int z = 0; z < jarray.length(); z++) {
//                        JSONObject j = jarray.getJSONObject(z);
//
//                        itineraries4.add(new Itinerary(j.getString("spotName") + " " + j.getString("description"), j.getString("startTime"), j.getString("endTime"), j.getString("spotName")));
//                        for (int y = 0; y < tempSpots.size(); y++) {
//                            if (j.getString("spotName").equals(tempSpots.get(y).getSpotName())) {
//                                spotIt3.add(tempSpots.get(y));
//                            }
//                        }
//
//                    }
//                    myTours.add(new TouristaPackages(object.getString("packageId"), object.getString("packageName"), itineraries4, "Local", Double.parseDouble(object.getString("rating")), jarray.length(), Integer.parseInt(object.getString("duration")), object.getString("photoPath"), spotIt3, object.getString("description"), object.getString("payment"), object.getString("agencyName"), object.getString("tourTransactionId"), object.getString("type")));
//
//                    // do some stuff....
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//                Log.d("changwapo", e + " package");
//            }
//            return myTours;
//        }
//    }

    public static ArrayList<Spots2> getControllerSpots(){
        finalSpotList.clear();

        try {
            new GetSpots().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Log.d("changwapo","finalSpotList "+finalSpotList.size());
        return finalSpotList;
    }

    static class GetSpots extends AsyncTask<Void, Void, ArrayList<Spots2>> {


        @Override
        protected ArrayList<Spots2> doInBackground(Void... voids) {
            try {
                JSONArray json = new JSONArray(HttpUtils.GET(finurl+"api/get-featured-spots"));
                for(int n = 0; n < json.length(); n++)
                {
                    JSONObject object = json.getJSONObject(n);

                    Log.d("changwapito",n+" spots");
                    Log.d("changwapito",object.getString("spotName")+" spots");
                    finalSpotList.add(new Spots2(object.getString("spotId"),object.getString("spotName"),object.getString("streetAddress"),object.getString("opening"),object.getString("closing"),object.getString("description"),object.getString("LONGITUDE"),object.getString("LATITUDE"),5,object.getString("photoPath"),object.getString("city"),object.getString("hours")));
                    Log.d("changwapito",object.getString("photoPath")+" spots");
                }
            } catch (JSONException e) {
                e.printStackTrace();

                Log.d("changwapo",e+" spots");
            }
            return finalSpotList;
        }


    }
    public static void removeSpot(String packId,String spotiD){
        JSONObject json = new JSONObject();

        try {
            json.put("spotId",spotiD);
            json.put("packageId",packId);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        RemoveSpot pr= new RemoveSpot();
        pr.execute(json);
    }
    public static class RemoveSpot extends AsyncTask<JSONObject, Void, JSONObject> {

        @Override
        protected JSONObject doInBackground(JSONObject... params) {

            postToDb("api/delete-spot-package",params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject rt) {

            super.onPostExecute(rt);
        }
    }

}