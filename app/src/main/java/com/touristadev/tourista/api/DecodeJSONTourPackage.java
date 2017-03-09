package com.touristadev.tourista.api;

import android.util.Log;

import com.touristadev.tourista.dataModels.SpotsPackage;
import com.touristadev.tourista.dataModels.TourPackage;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 3/9/2017.
 */

public class DecodeJSONTourPackage {
    public static ArrayList<TourPackage> DecodeJSONTourPackage(String json) {
        ArrayList<TourPackage> tourPackages = new ArrayList<>();
        JSONArray jsonObject;
        try {
            jsonObject = new JSONArray(json);
            for (int x = 0; x < jsonObject.length(); x++) {
                tourPackages.add(new TourPackage(
                        jsonObject.getJSONObject(x).getString(TourPackage.PACKAGEID),
                        jsonObject.getJSONObject(x).getString(TourPackage.PACKAGENAME),
                        jsonObject.getJSONObject(x).getString(TourPackage.TRAVELAGENCYID),
                        Float.parseFloat(jsonObject.getJSONObject(x).getString(TourPackage.PAYMENT)),
                        jsonObject.getJSONObject(x).getInt(TourPackage.NUMOFTGNEEDED),
                        Float.parseFloat(jsonObject.getJSONObject(x).getString(TourPackage.RATING)),
                        jsonObject.getJSONObject(x).getString(TourPackage.DESCRIPTION),
                        jsonObject.getJSONObject(x).getString(TourPackage.DURATION),
                        jsonObject.getJSONObject(x).getInt(TourPackage.NUMOFSPOTS),
                        jsonObject.getJSONObject(x).getInt(TourPackage.MINPEOPLE),
                        jsonObject.getJSONObject(x).getString(TourPackage.PHOTOFILENAME),
                        jsonObject.getJSONObject(x).getString(TourPackage.CATEGORY),
                        DecodeJSONSpotsPackage(jsonObject.getJSONObject(x).getJSONArray(TourPackage.SPOTS))));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("Boholst", tourPackages.toString());
        return tourPackages;
    }

    public static ArrayList<SpotsPackage> DecodeJSONSpotsPackage(String json) {
        ArrayList<SpotsPackage> spots = new ArrayList<>();
        JSONArray jsonObject;
        try {
            jsonObject = new JSONArray(json);
            for (int x = 0; x < jsonObject.length(); x++) {
                spots.add(new SpotsPackage(
                        jsonObject.getJSONObject(x).getString(SpotsPackage.PACKAGEID),
                        jsonObject.getJSONObject(x).getString(SpotsPackage.sLONGITUDE),
                        jsonObject.getJSONObject(x).getInt(SpotsPackage.CHRONOLOGY),
                        jsonObject.getJSONObject(x).getString(SpotsPackage.SPOTID),
                        jsonObject.getJSONObject(x).getString(SpotsPackage.STARTTIME),
                        jsonObject.getJSONObject(x).getString(SpotsPackage.PHOTOFILENAME),
                        jsonObject.getJSONObject(x).getString(SpotsPackage.DESCRIPTION),
                        jsonObject.getJSONObject(x).getString(SpotsPackage.SPOTNAME),
                        jsonObject.getJSONObject(x).getString(SpotsPackage.HOURS),
                        jsonObject.getJSONObject(x).getString(SpotsPackage.sLATITUDE),
                        jsonObject.getJSONObject(x).getString(SpotsPackage.ENDTIME)
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return spots;
    }

    public static ArrayList<SpotsPackage> DecodeJSONSpotsPackage(JSONArray jsonObject) {
        ArrayList<SpotsPackage> spots = new ArrayList<>();
        try {
            for (int x = 0; x < jsonObject.length(); x++) {
                spots.add(new SpotsPackage(
                        jsonObject.getJSONObject(x).getString(SpotsPackage.PACKAGEID),
                        jsonObject.getJSONObject(x).getString(SpotsPackage.sLONGITUDE),
                        jsonObject.getJSONObject(x).getInt(SpotsPackage.CHRONOLOGY),
                        jsonObject.getJSONObject(x).getString(SpotsPackage.SPOTID),
                        jsonObject.getJSONObject(x).getString(SpotsPackage.STARTTIME),
                        jsonObject.getJSONObject(x).getString(SpotsPackage.PHOTOFILENAME),
                        jsonObject.getJSONObject(x).getString(SpotsPackage.DESCRIPTION),
                        jsonObject.getJSONObject(x).getString(SpotsPackage.SPOTNAME),
                        jsonObject.getJSONObject(x).getString(SpotsPackage.HOURS),
                        jsonObject.getJSONObject(x).getString(SpotsPackage.sLATITUDE),
                        jsonObject.getJSONObject(x).getString(SpotsPackage.ENDTIME)
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return spots;
    }
}
