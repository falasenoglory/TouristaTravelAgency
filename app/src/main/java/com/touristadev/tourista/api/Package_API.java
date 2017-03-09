//package com.touristadev.tourista.api;
//
//import android.util.Log;
//
//import com.touristadev.tourista.activities.PackageActivity;
//import com.touristadev.tourista.dataModels.BookedPackage;
//import com.touristadev.tourista.dataModels.Itinerary;
//import com.touristadev.tourista.dataModels.Spots;
//import com.touristadev.tourista.dataModels.TourGuide;
//import com.touristadev.tourista.dataModels.TourPackage;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//
///**
// * Created by Shanyl Jimenez on 2/26/2017.
// */
//
//public class Package_API {
//
//    public static ArrayList<TourPackage> BookedList = new ArrayList<>();
//
//    public static ArrayList<TourPackage> getBookedPackages(String json) {
//
//        Log.d("Shanyl","Request API json: "+ json);
//        // Here we will now parse the json response and convert it into a TourRequest object.
//        int numOfSpots;
//        int rating;
//        String description;
//        String travelAgencyId;
//        String packageId;
//        String duration;
//        String payment;
//        String category;
//        String photoPath;
//        String packageName;
//        int numOfTGNeeded;
//        int minPeople;
//
//        ArrayList<Spots>= new ArrayList<>();
//        String description;
//
//
//        JSONArray array= null;
//        try {
//            array = new JSONArray(json);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        try {
//            for(int n = 0; n < array.length(); n++)
//            {
//                JSONObject rq = array.getJSONObject(n);
//                // do some stuff....
//                tourTransactionId =rq.getString("tourTransactionId");
//                agencyName =rq.getString("agencyName");
//                photoPath =rq.getString("photoPath");
//                TGPayment =rq.getString("TGPayment");
//                numOfSpots =rq.getString("numOfSpots");
//                price=rq.getString("price");
//                touristName=rq.getString("touristName");
//                status=rq.getString("status");
//                numOfPeople=rq.getInt("numOfPeople");
//                packageId=rq.getString("packageId");
//                tourDate=rq.getString("tourDate");
//                userId=rq.getString("userId");
//                packageName=rq.getString("packageName");
//                reserveDate=rq.getString("reserveDate");
//                rating=rq.getInt("rating");
//                description=rq.getString("description");
//                type=rq.getString("type");
//
//                JSONArray arrayItinerary = rq.getJSONArray("itinerary_details");
//                for(int i=0;i<arrayItinerary.length();i++)
//                {
//                    JSONObject it= arrayItinerary.getJSONObject(i);
//                    chronology=it.getInt("chronology");
//                    spotId=it.getString("spotId");
//                    startTime=it.getString("startTime");
//                    spotName=it.getString("spotName");
//                    LATITUDE=it.getString("LATITUDE");
//                    endTime=it.getString("endTime");
//                    LONGITUDE=it.getString("LONGITUDE");
//                    description=it.getString("description");
//                    photofilename=it.getString("photoFileName");
//
//                    Itinerary itinerary= new Itinerary(chronology,photofilename,spotId,startTime,spotName,LATITUDE,endTime,LONGITUDE,description);
//                    itenerary_details.add(itinerary);
//                }
//
//
//                BookedPackage amt = new BookedPackage(tourTransactionId,description,status,numOfPeople,agencyName,photoPath,TGPayment,numOfSpots,price,touristName,packageId,tourDate,userId
//                        ,packageName,reserveDate,rating,type,itenerary_details);
//                Log.d("Shanyl","Request API amt.tostring: "+ amt.toString());
//                BookedList.add(amt);
//
//                Log.d("Shanyl","Request API TourRequestList: "+ BookedList.toString());
//            }
//
//
//            return BookedList;
//
//        } catch (JSONException e) {
//            Log.d("chanR", "NASAYOP RA ANG TANAN!" + e.toString());
//            e.printStackTrace();
//            return null;
//        }
//
//
//
//
//
//
//    }
//}
