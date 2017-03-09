package com.touristadev.tourista.api;

import android.util.Log;

import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.TGAcceptance;
import com.touristadev.tourista.dataModels.TourGuide;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 1/23/2017.
 */

public class CurrentUser_API {

    public static final String API_URL = "http://192.168.2.104:8000/api/authenticate";

    public static TourGuide getCurrentTourGuideList(JSONObject json) {
        // Here we will now parse the json response and convert it into a Weather object.
            try {
    //  "numReject": null, "": "User", "PROFILE_DESCRIPTION": "dsa", "userId": "4WsRc7IsriQIyuA7zraN24Cgcl12", "streetAddress": "Oldog", "zipCode": "032", "priority": 10, "numAccept": null, "contactNumber": "on hold", "birthday": "2016-02-11", "country": "Philippines", "facebookId": "162018050953000", "EMAIL": "open_eomwxqf_user@tfbnw.net", "card_details": {}}

     //           Log.d("Shanyl","CU_API: "+json.toString());
                // do some stuff....
                String TGFirebaseId=json.getString("userId");
                String TGfacebookId=json.getString("facebookId");
                String TGGuideID=json.getString("guideId");
                String TGEmail=json.getString("EMAIL");
                String TGPhotoUrl=json.getString("photoUrl");
                String TGfirstName=json.getString("firstName");
                String TGlastName=json.getString("lastName");
                String TGProfileDescription=json.getString("PROFILE_DESCRIPTION");
                String TGcellphoneNumber=json.getString("contactNumber");
                String TGdateOfBirth=json.getString("birthday");
                String TGcitizenship=json.getString("citizenship");
                String TGCity=json.getString("province");
                String TGStreedAddress=json.getString("streetAddress");
                String TGCounty=json.getString("country");
                String TGZipCode=json.getString("zipCode");
                int NoOfRequest=Integer.parseInt(json.getString("numRequest"));
                int NoOfAccepted= Integer.parseInt(json.getString("numAccept"));
                double genAllRating=Double.parseDouble(json.getString("ratings"));
                int genAcceptanceRating=98;
                ArrayList<String> TGLanguages=new ArrayList<>();


                TGAcceptance acceptanceRating= new TGAcceptance();
//
//                ArrayList<String> TGLanguages=new ArrayList<>();
//                JSONArray jsonarray = new JSONArray(json.getJSONArray("language"));
//                for (int i = 0; i < jsonarray.length(); i++) {
//                    String lang = jsonarray.getJSONObject(i).toString();
//                    TGLanguages.add(lang);
//
//                }

//                ArrayList<TGRating> TGRatings=new ArrayList<>();
//               double r1,r2,r3;
//                JSONArray jsonarraylang = new JSONArray(json.getJSONArray("language"));
//                for (int i = 0; i < jsonarray.length(); i++) {
//                    r1 = jsonarraylang.getJSONObject(i).getDouble("");
//                    r2 = jsonarraylang.getJSONObject(i).getDouble("");
//                    r3 = jsonarraylang.getJSONObject(i).getDouble("");
//                    TGRatings.add(new TGRating(r1,r2,r3));
//
//                }


                double actsProfessionally=Double.parseDouble(json.getString("acts_professionaly"));
                double isKnowledgeable=Double.parseDouble(json.getString("isknowledgeable"));
                double hasTheRightPersonality=Double.parseDouble(json.getString("rightpersonality"));
                int TGcountPriority=Integer.parseInt(json.getString("priority"));
                String TGCreditCardEmail=json.getString("creditCardEmail");
                String TGCreditCardPassword=json.getString("creditCardPassword");
                String TGCreditCardNo=json.getString("accountNumber");
                String TGCreditExpiryMo=json.getString("expirationDateMonth");
                String TGCreditExpiryYr=json.getString("expirationDateYear");
                String TGCreditExpiryDay=json.getString("expirationDateDay");
                String TGCreditCVV=json.getString("cvv");

                TourGuide amt = new TourGuide(TGFirebaseId,TGfacebookId,TGGuideID,TGEmail,TGPhotoUrl,TGfirstName," ",TGlastName,TGProfileDescription,TGcellphoneNumber,TGdateOfBirth,TGcitizenship,TGCity,TGStreedAddress,TGCounty,TGZipCode,genAllRating,genAcceptanceRating,TGLanguages,actsProfessionally,isKnowledgeable,hasTheRightPersonality,TGcountPriority,TGCreditCardEmail,TGCreditCardPassword,TGCreditCardNo,TGCreditExpiryMo,TGCreditExpiryYr,TGCreditExpiryDay,TGCreditCVV);
                Log.d("Shanyl","TG model: "+amt.toString());
                Controllers.CurrentGT=amt;
                Log.d("Shanyl","Controller model: "+amt.toString());


            return amt;

        } catch (JSONException e) {
            Log.d("chanF", "NASAYOP RA ANG TANAN!" + e.toString());
            e.printStackTrace();
            return null;
        }






    }
}
