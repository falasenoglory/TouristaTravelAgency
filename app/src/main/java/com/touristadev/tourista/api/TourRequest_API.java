package com.touristadev.tourista.api;

import android.util.Log;

import com.touristadev.tourista.dataModels.Itinerary;
import com.touristadev.tourista.dataModels.TourRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 1/6/2017.
 */

public class TourRequest_API {

    public static ArrayList<TourRequest> TourRequestList = new ArrayList<>();

    public static ArrayList<TourRequest> getTourRequestList(String json) {

        Log.d("Shanyl","Request API json: "+ json);
        // Here we will now parse the json response and convert it into a TourRequest object.

        String tourTransactionId;
        String status;
        int numOfPeople;
        String agencyName;
        String photoPath;
        String TGPayment;
        String numOfSpots;
        String price;
        String touristName;
        String packageId;
        String tourDate;
        String userId;
        String packageName;
        String reserveDate;
        ArrayList<Itinerary> itenerary_details= new ArrayList<>();
        int chronology;
        String spotId;
        String startTime;
        String spotName;
        String LATITUDE;
        String endTime;
        String LONGITUDE;
        String description;
        String photofilename;
        String type;
        int rating;


        JSONArray array= null;
        try {
            array = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            for(int n = 0; n < array.length(); n++)
            {
                JSONObject rq = array.getJSONObject(n);
                // do some stuff....
                tourTransactionId =rq.getString("tourTransactionId");
                agencyName =rq.getString("agencyName");
                photoPath =rq.getString("photoPath");
                TGPayment =rq.getString("TGPayment");
                numOfSpots =rq.getString("numOfSpots");
                price=rq.getString("price");
                touristName=rq.getString("touristName");
                status=rq.getString("status");
                numOfPeople=rq.getInt("numOfPeople");
                packageId=rq.getString("packageId");
                tourDate=rq.getString("tourDate");
                userId=rq.getString("userId");
                packageName=rq.getString("packageName");
                reserveDate=rq.getString("reserveDate");
                rating=rq.getInt("rating");
                description=rq.getString("description");
                type= rq.getString("type");


                JSONArray arrayItinerary = rq.getJSONArray("itinerary_details");
                itenerary_details.clear();
                for(int i=0;i<arrayItinerary.length();i++)
                {
                    JSONObject it= arrayItinerary.getJSONObject(i);
                    chronology=it.getInt("chronology");
                    spotId=it.getString("spotId");
                    startTime=it.getString("startTime");
                    spotName=it.getString("spotName");
                    LATITUDE=it.getString("LATITUDE");
                    endTime=it.getString("endTime");
                    LONGITUDE=it.getString("LONGITUDE");
                    description=it.getString("description");
                    photofilename=it.getString("photoFileName");

                    Itinerary itinerary= new Itinerary(chronology,photofilename,spotId,startTime,spotName,LATITUDE,endTime,LONGITUDE,description);
                    itenerary_details.add(itinerary);
                }


                TourRequest amt = new TourRequest(tourTransactionId,description,status,numOfPeople,agencyName,photoPath,TGPayment,numOfSpots,price,touristName,packageId,tourDate,userId
                        ,packageName,reserveDate,rating,type,itenerary_details);
                Log.d("Boholst","Request API amt: "+ amt.getItenerary_details().toString());
                TourRequestList.add(amt);

                Log.d("Shanyl","Request API TourRequestList: "+ TourRequestList);
            }


            return TourRequestList;

        } catch (JSONException e) {
            Log.d("chanR", "NASAYOP RA ANG TANAN!" + e.toString());
            e.printStackTrace();
            return null;
        }






    }}
