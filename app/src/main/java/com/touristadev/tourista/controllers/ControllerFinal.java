//package com.touristadev.tourista.controllers;
//
//
//import android.util.Log;
//
//import com.google.android.gms.maps.model.LatLng;
//import com.google.firebase.auth.FirebaseUser;
//import com.touristadev.tourista.R;
//import com.touristadev.tourista.dataModels.BookedPackage;
//import com.touristadev.tourista.dataModels.Categories;
//import com.touristadev.tourista.dataModels.CustomizedPackage;
//import com.touristadev.tourista.dataModels.Itinerary;
//import com.touristadev.tourista.dataModels.Spots;
//import com.touristadev.tourista.dataModels.TouristaPackages;
//import com.touristadev.tourista.dataModels.Tribes;
//
//import java.util.ArrayList;
//
///**
// * Created by Shanyl Jimenez on 2/5/2017.
// */
//
//public class ControllerFinal {
//
//    public static String PACKAGE_REQUEST= "Request";
//    public static String PACKAGE_BOOKED= "Booked";
//    public static String PACKAGE_HISTORY= "History";
//    public static String PACKAGE_CUSTOM= "Custom";
//    public static String PACKAGE_TA= "TA";
//
//    public static ArrayList<Spots> finalSpotList = new ArrayList<>();
//    public static ArrayList<TouristaPackages> RecentList = new ArrayList<>();
//
//    public static ArrayList<TouristaPackages> packageList = new ArrayList<>();
//    public static ArrayList<CustomizedPackage> customizedPackageList = new ArrayList<>();
//    public static ArrayList<BookedPackage> RequestList = new ArrayList<>();
//    public static ArrayList<BookedPackage> BookedList = new ArrayList<>();
//    public static ArrayList<BookedPackage> HistoryList = new ArrayList<>();
//
//    public static FirebaseUser user;
//    public static LatLng currentLocation;
//    public static String currentUser;
//    public static ArrayList<TouristaPackages> WishList = new ArrayList<>();
//    public static ArrayList<Spots> spotIt3 = new ArrayList<>();
//    public static int positionwew;
//    public static float ratPack;
//
//    public static void ControllerFinal() {
//
//        getControllerSpots();
//        packageList.clear();
//
//        ArrayList<TouristaPackages> L1= new ArrayList<>();
//        ArrayList<Categories> categories1 = new ArrayList<>();
//        ArrayList<Tribes> tribes1 = new ArrayList<>();
//        ArrayList<Spots> spotIti = new ArrayList<>();
//        ArrayList<Itinerary> itineraries1 = new ArrayList<>();
//
//        ArrayList<TouristaPackages> L2= new ArrayList<>();
//        ArrayList<Categories> categories2 = new ArrayList<>();
//        ArrayList<Tribes> tribes2 = new ArrayList<>();
//        ArrayList<Spots> spotIt2 = new ArrayList<>();
//        ArrayList<Itinerary> itineraries2 = new ArrayList<>();
//
//        ArrayList<TouristaPackages> L3= new ArrayList<>();
//        ArrayList<Categories> categories3 = new ArrayList<>();
//        ArrayList<Tribes> tribes3 = new ArrayList<>();
//        ArrayList<Itinerary> itineraries3 = new ArrayList<>();
//
//
//        ArrayList<TouristaPackages> L4= new ArrayList<>();
//        ArrayList<Categories> categories4 = new ArrayList<>();
//        ArrayList<Tribes> tribes4 = new ArrayList<>();
//        ArrayList<Spots> spotIt4 = new ArrayList<>();
//        ArrayList<Itinerary> itineraries4 = new ArrayList<>();
//
//
//        /// PACKAGE ////////////////////////////////////////////////////////////////////////////////
//
//        categories1.add(new Categories("Adventure"));
//        categories1.add(new Categories("Nature"));
//        categories1.add(new Categories("Beaches and Resorts"));
//        categories1.add(new Categories("Beaches and Resorts"));
//
//        tribes1.add(new Tribes("Thrill-seeker"));
//        tribes1.add(new Tribes("Backpacker"));
//        tribes1.add(new Tribes("Escapist"));
//        spotIti.add(finalSpotList.get(1));
//        spotIti.add(finalSpotList.get(0));
//        itineraries1.add(new Itinerary("Pick up location","05:00","08:00"));
//        itineraries1.add(new Itinerary(finalSpotList.get(1).getSpotName(),"08:00","11:00"));
//        itineraries1.add(new Itinerary("Lunch","11:00","13:00"));
//        itineraries1.add(new Itinerary(finalSpotList.get(0).getSpotName(),"13:00","16:00"));
//
//        L1.add(new TouristaPackages("asfa231","South Cebu Tours",itineraries1,"Local",4,2,8,R.mipmap.spot_cebusouthtour,spotIti,"DESCRIPTION","1705","Colt Travel and Tours"));
//
//        /// PACKAGE ////////////////////////////////////////////////////////////////////////////////
//
//
//
//        spotIt2.add(finalSpotList.get(4));
//        spotIt2.add(finalSpotList.get(3));
//        spotIt2.add(finalSpotList.get(2));
//        itineraries2.add(new Itinerary("Pick up location","06:00","09:00"));
//        itineraries2.add(new Itinerary(finalSpotList.get(2).getSpotName(),"09:00","12:00"));
//        itineraries2.add(new Itinerary("Lunch","12:00","13:00"));
//        itineraries2.add(new Itinerary(finalSpotList.get(3).getSpotAddress(),"13:00","15:00"));
//        itineraries2.add(new Itinerary(finalSpotList.get(4).getSpotName(),"15:00","17:00"));
//
//        L2.add(new TouristaPackages("14as25","Cebu Pilgrimage",itineraries2,"Local",4,3,8,R.mipmap.spot_stonino,spotIt2,"DESCRIPTION","1500","Colt Travel and Tours"));
//
//
//        /// PACKAGE ////////////////////////////////////////////////////////////////////////////////
//
//        categories3.add(new Categories("Adventure"));
//        categories3.add(new Categories("Aquaria"));
//        categories3.add(new Categories("Nature"));
//
//        tribes3.add(new Tribes("Thrill-Seeker"));
//        tribes3.add(new Tribes("Escapist"));
//        tribes3.add(new Tribes("The Self-Improver"));
//        tribes3.add(new Tribes("Genuinely Curious"));
//
//
//        spotIt3.add(finalSpotList.get(4));
//        spotIt3.add(finalSpotList.get(1));
//        spotIt3.add(finalSpotList.get(5));
//        spotIt3.add(finalSpotList.get(0));
//        itineraries3.add(new Itinerary("Pick up location","05:00","08:00"));
//        itineraries3.add(new Itinerary(finalSpotList.get(1).getSpotName(),"08:00","08:30"));
//        itineraries3.add(new Itinerary("Short briefing then proceed to Whale Shark Watching / Snorkelin","08:30","11:00"));
//        itineraries3.add(new Itinerary("Lunch","11:00","12:00"));
//        itineraries3.add(new Itinerary(finalSpotList.get(5).getSpotName(),"12:00","15:00"));
//        itineraries3.add(new Itinerary("Departure Time","15:00","17:00"));
//
//        L3.add(new TouristaPackages("24asf","Oslob Whale Watching",itineraries3,"Local",4,2,12,R.mipmap.spot_oslobwhalshark,spotIt3,"DESCRIPTION","1250","Colt Travel and Tours"));
//
//        /// PACKAGE ////////////////////////////////////////////////////////////////////////////////
//
//
//        spotIt4.add(finalSpotList.get(0));
//        spotIt4.add(finalSpotList.get(2));
//        itineraries4.add(new Itinerary("Pick up location","05:00","08:00"));
//        itineraries4.add(new Itinerary(finalSpotList.get(0).getSpotName(),"08:00","08:30"));
//        itineraries4.add(new Itinerary("Short briefing then proceed to Whale Shark Watching / Snorkelin","08:30","11:00"));
//        itineraries4.add(new Itinerary("Lunch","11:00","12:00"));
//        itineraries4.add(new Itinerary(finalSpotList.get(2).getSpotName(),"12:00","15:00"));
//        itineraries4.add(new Itinerary("Departure Time","15:00","17:00"));
//
//        L4.add(new TouristaPackages("01","Summer Adventure",itineraries4,"Local",0,2,12,R.mipmap.ic_launcher,spotIt4,"Tourista adventure","10,000","Destination Travel and Tours"));
//
//
//        /// PACKAGE ////////////////////////////////////////////////////////////////////////////////
//
//
//
//        packageList.clear();
//        packageList.add(L1.get(0));
//        packageList.add(L2.get(0));
//        packageList.add(L3.get(0));
//        packageList.add(L4.get(0));
//
//
//    }
//
//    public static ArrayList<Spots> getControllerSpots(){
//        finalSpotList.clear();
//
//        Log.d("packTG","Controllers ");
//        ArrayList<String> activities0 = new ArrayList<>();
//        ArrayList<Categories> categories0 = new ArrayList<>();
//        ArrayList<Tribes> tribes0 = new ArrayList<>();
//
//        activities0.add("Swimming");
//
//        categories0.add(new Categories("Beaches and Resorts"));
//        categories0.add(new Categories("Nature"));
//
//        tribes0.add(new Tribes("Comformist"));
//        tribes0.add(new Tribes("Thrill- Seeker"));
//        tribes0.add(new Tribes("Self- Improver"));
//        finalSpotList.clear();
//
//        finalSpotList.add(new Spots("0","Masters Resort Cebu","4044 Oslob, Cebu, Philippines",
//                "8:00","21:00","The southern part of the province is one of the areas where you can enjoy various sorts of seawater activities, do adventurous trips, have fun and cherish the tranquil ambiance and surroundings."
//                ,"9.459556960067692","123.37731275707483",4, R.mipmap.spot_oslobwhalshark));
//
//        // SPOT ////////////////////////////////////////////////////////////////////////////////////
//
//        ArrayList<String> activities1 = new ArrayList<>();
//        ArrayList<Categories> categories1 = new ArrayList<>();
//        ArrayList<Tribes> tribes1 = new ArrayList<>();
//
//        activities1.add("Whale watching");
//        activities1.add("Scuba Diving");
//
//        categories1.add(new Categories("Nature"));
//        categories1.add(new Categories("Aquaria"));
//        categories1.add(new Categories("Beaches and Resorts"));
//
//        tribes1.add(new Tribes("Comformist"));
//        tribes1.add(new Tribes("Thrill- Seeker"));
//        tribes1.add(new Tribes("Self- Improver"));
//
//        finalSpotList.add(new Spots("1","Oslob Whale Shark Watching","Tan-awan Oslob, Cebu, Ph",
//                "8:00","12:00","Oslob Whalesharks watching was born to give information about whale shark interaction in Oslob, we are here to organize day tour trips on whale shark encounters with side trip to Tumalog waterfalls. We"
//                ,"9.47008451293314","123.38275127112864",4,R.mipmap.spot_oslobwhalshark));
//
//
//        // SPOT ////////////////////////////////////////////////////////////////////////////////////
//
//        ArrayList<String> activities2 = new ArrayList<>();
//        ArrayList<Categories> categories2 = new ArrayList<>();
//        ArrayList<Tribes> tribes2 = new ArrayList<>();
//
//
//        activities2.add("Attend Mass");
//        activities2.add("Visit Magellan's Cross");
//
//        categories2.add(new Categories("Church"));
//        categories2.add(new Categories("Historical"));
//        categories2.add(new Categories("Museum"));
//
//        tribes2.add(new Tribes("Collector"));
//        tribes2.add(new Tribes("The Self-Improver"));
//        tribes2.add(new Tribes("Pilgrim"));
//
//        finalSpotList.add(new Spots("2","Basilica del Santo Niño","Santo Nino Chapel Lane, Cebu City, Cebu"
//                ,"5:00","20:00","The oldest Roman Catholic church in the country, it is built on the spot where the image of the Santo Niño de Cebú was found during the expedition of Miguel López de Legazpi. "
//                ,"10.294194","123.902106",4,R.mipmap.stnino));
//
//
//        // SPOT ////////////////////////////////////////////////////////////////////////////////////
//        ArrayList<String> activities3 = new ArrayList<>();
//        ArrayList<Categories> categories3 = new ArrayList<>();
//        ArrayList<Tribes> tribes3 = new ArrayList<>();
//
//
//        activities3.add("Dicover Ancient cebu stories.");
//        activities3.add("Visist historical Artifacts.");
//
//        categories3.add(new Categories("Historical"));
//        categories3.add(new Categories("Museum"));
//
//        tribes3.add(new Tribes("Collector"));
//        tribes3.add(new Tribes("The Self-Improver"));
//        tribes3.add(new Tribes("Pilgrim"));
//        tribes3.add(new Tribes("Genuinely Curious"));
//
//        finalSpotList.add(new Spots("3", "Museo Sugbo", "M. J. Cuenco Ave, Cebu City, 6000 Cebu",
//                "9:00","17:30","Museo Sugbo is the Cebu Provincial Museum located in the former Cebu Provincial Detention and Rehabilitation Center, four blocks from Plaza Independencia."
//                , "10.303781",  "123.906758",
//                4,R.mipmap.msugbo));
//
//        // SPOT ////////////////////////////////////////////////////////////////////////////////////
//
//        ArrayList<String> activities4 = new ArrayList<>();
//        ArrayList<Categories> categories4 = new ArrayList<>();
//        ArrayList<Tribes> tribes4 = new ArrayList<>();
//
//        activities4.add("Explore Museum");
//
//        categories4.add(new Categories("Historical"));
//        categories4.add(new Categories("Nature"));
//        categories4.add(new Categories("Art Galleries"));
//        categories4.add(new Categories("Museums"));
//        categories4.add(new Categories("Park"));
//
//        tribes4.add(new Tribes("Collector"));
//        tribes4.add(new Tribes("The Self-Improver"));
//        tribes4.add(new Tribes("Pilgrim"));
//        tribes4.add(new Tribes("Genuinely Curious"));
//
//        finalSpotList.add( new Spots("4","Fort San Pedro", "A. Pigafetta Street, Cebu City, 6000"
//                ,"7:00", "19:00", "One of the city’s historical attractions is Fort San Pedro which is known as the smallest and oldest fort in the Philippines.",
//                "10.292499","123.905828",4,R.mipmap.fsanpedro));
//
//        // SPOT ////////////////////////////////////////////////////////////////////////////////////
//
//        ArrayList<String> activities5 = new ArrayList<>();
//        ArrayList<Categories> categories5 = new ArrayList<>();
//        ArrayList<Tribes> tribes5 = new ArrayList<>();
//
//        activities5.add("Swimming");
//        activities5.add("Scuba Diving");
//
//        categories5.add(new Categories("Adventure"));
//        categories5.add(new Categories("Aquaria"));
//        categories5.add(new Categories("Beaches and Resorts"));
//        categories5.add(new Categories("Nature"));
//
//        tribes5.add(new Tribes("Thrill-Seeker"));
//        tribes5.add(new Tribes("Escapist"));
//        tribes5.add(new Tribes("The Self-Improver"));
//        tribes5.add(new Tribes("Genuinely Curious"));
//
//        finalSpotList.add(new Spots("5","Tumalog Falls","Cebu South Rd, Oslob, Cebu",
//                "5:00","22:00","Tumalog Falls (also called the “Toslob Falls” or “Mag-ambak Falls”) is situated in the town of Oslob, Cebu. It is just about 15-20 minutes ride from the whale-watching site.",
//                "9.486560"," 123.369264",54,R.mipmap.tml));
//
//        // SPOT ////////////////////////////////////////////////////////////////////////////////////
//
//        ArrayList<String> activities6 = new ArrayList<>();
//        ArrayList<Categories> categories6 = new ArrayList<>();
//        ArrayList<Tribes> tribes6 = new ArrayList<>();
//
//        activities6.add("Swimming");
//
//        categories6.add(new Categories("Adventure"));
//        categories6.add(new Categories("Nature"));
//
//
//        tribes6.add(new Tribes("Thrill-Seeker"));
//        tribes6.add(new Tribes("The Self-Improver"));
//        tribes6.add(new Tribes("Genuinely Curious"));
//
//        finalSpotList.add(new Spots("6","Kawasan Falls","Matutinao,, Badian, 6031 Cebu",
//                "5:00","22:00","Cebu kawasan falls Cebu is a peaceful natural place where you can enjoy many waterfalls of natural spring water located near the southern tip of Cebu Philippines.. A gentle hush of rushing ice cool water."
//                ,"9.811219", "123.374875",4,R.mipmap.kws));
//
//
//        // SPOT ////////////////////////////////////////////////////////////////////////////////////
//
//
//        ArrayList<String> activities7 = new ArrayList<>();
//        ArrayList<Categories> categories7 = new ArrayList<>();
//        ArrayList<Tribes> tribes7 = new ArrayList<>();
//
//        activities7.add("Cultural exhibits near a historic church.");
//        activities7.add("Iconic citadel and with a hero's memorial.");
//
//        categories7.add(new Categories("Art Galleries"));
//        categories7.add(new Categories("Building and Structure"));
//        categories7.add(new Categories("Church"));
//        categories7.add(new Categories("Historical"));
//        categories7.add(new Categories("Museums"));
//
//        tribes7.add(new Tribes("Thrill-Seeker"));
//        tribes7.add(new Tribes("Collector"));
//        tribes7.add(new Tribes("Genuinely Curious"));
//        tribes7.add(new Tribes("Pilgrim"));
//        tribes7.add(new Tribes("Pilgrim"));
//
//        finalSpotList.add(new Spots("7","Intrauros","Bonifacio Dr & Padre Burgos St, Manila, Luzon 1002, Philippines",
//                "8:00 AM","10:00 PM","Intramuros is the oldest district and historic core of Manila, Philippines. ... Map of Metro Manila showing the location of Intramuros."
//                ,"9.811219", "123.374875",4,R.mipmap.kws));
//
//
//        return finalSpotList;
//    }
//
//    /// <REQUEST> ////////////////////////////////////////////////////////
//
//    public static void removeRequestPackage(int pos)
//    {
//        ControllerFinal();
//        RequestList.remove(pos);
//
//    }
//
//    public static void addRequestPackage(BookedPackage pg)
//    {
//        ControllerFinal();
//        RequestList.add(pg);
//
//    }
//
//    public static ArrayList<BookedPackage> getAllRequestPackage()
//    {
//        ControllerFinal();
//        return RequestList;
//
//    }
//
//    public static BookedPackage getRequestPackage(int position)
//    {
//        ControllerFinal();
//
//        return RequestList.get(position);
//
//    }
//
//    public static int getPackagePosition (String packageID){
//    ControllerFinal();
//
//            int a =0;
//
//            for(int i=0;i< RequestList.size();i++) {
//                if (RequestList.get(i).getTourpackage().getPackageId().equals(packageID))
//                    a = i;
//            }
//
//
//           return a;
//
//}
//
//
//    /// </REQUEST> ////////////////////////////////////////////////////////
//
//    /// <CUSTOMIZED> ///////////////////////////////////////////////////
//    public static void addCustomizedPackage(CustomizedPackage pack){
//        ControllerFinal();
//        customizedPackageList.add(pack);
//
//    }
//
//    public static void removeCustomizedPackage(int index){
//        customizedPackageList.remove(index);
//
//    }
//
//    public static ArrayList<CustomizedPackage> getCustomizedPackageList(){
//        ControllerFinal();
//        return customizedPackageList;
//    }
//
//    /// <CUSTOMIZED> ///////////////////////////////////////////////////
//
//    /// <HISTORY> ///////////////////////////////////////////////////
//
//    public static void addHistoryPackage(BookedPackage pack){
//        ControllerFinal();
//        HistoryList.add(pack);
//
//    }
//
//    public static void removeHistoryPackage(int index){
//        ControllerFinal();
//        customizedPackageList.remove(index);
//
//    }
//    public static ArrayList<BookedPackage> getHistoryPackageList(){
//        ControllerFinal();
//        return HistoryList;
//    }
//
//    public static BookedPackage getSpecificHistoryPackageList(int pos){
//        ControllerFinal();
//        return HistoryList.get(pos);
//    }
//
//
//    /// </HISTORY> ///////////////////////////////////////////////////
//    /// <BOOKED> ///////////////////////////////////////////////////
//
//    public static void removeBookedPackages(int pos)
//    {
//        BookedList.remove(pos);
//
//    }
//    public static void addBookPackages(BookedPackage pos)
//    {
//        BookedList.add(pos);
//
//    }
//
//    public static ArrayList<BookedPackage> getBookedList()
//    {
//        return BookedList;
//    }
//
//    public static BookedPackage getSpecificBookedList(int pos)
//    {
//        return BookedList.get(pos);
//    }
//
//
//    /// </BOOKED> ///////////////////////////////////////////////////
//
//    /// <TOURISTA PACKAGE> ///////////////////////////////////////////
//    public static ArrayList<TouristaPackages> getControllerPackaaes()
//    {
//        ControllerFinal();
//        return packageList;
//    }
//
//    /// <TOURISTA PACKAGE> ///////////////////////////////////////////
//
//
//    public static TouristaPackages getSpecificPackage(String packageID)
//    {
//        ControllerFinal();
//        TouristaPackages pg= new TouristaPackages();
//
//        for (int i=0; i<packageList.size();i++)
//        {
//
//            if(packageList.get(i).getPackageId().equals(packageID))
//            {
//                pg= packageList.get(i);
//            }
//        }
//
//        return pg;
//    }
//
//    public static String getCurrentUserID(){
//
//        ControllerFinal();
//        return currentUser;
//    }
//    public static void setCurrentUserID(String id){
//        ControllerFinal();
//        currentUser = id;
//    }
//
//    public static void addUser(FirebaseUser us)
//    {
//        ControllerFinal();
//        user = us;
//
//
//    }public static FirebaseUser getUser()
//    {
//
//        return user;
//
//    }
//
//
//    public static void removeWishPackage(int pos)
//    {
//        WishList.remove(pos);
//
//    }
//    public static void addWishPackage(TouristaPackages pos)
//    {
//        WishList.add(pos);
//
//    }
//
//
//    public static ArrayList<TouristaPackages> getRecentList(){
//        RecentList.clear();
//        return packageList;
//    }
//
//    public static ArrayList<TouristaPackages> getWishList()
//    {
//        return WishList;
//    }
////
////    public static ArrayList<TourGuideModel> getTourguideList(){
////        tourguideList.clear();
////        tourguideList.add(new TourGuideModel("Christian Ferolino", R.mipmap.ic_launcher, "Im gonna make you smile :)", 5, "18"));
////        tourguideList.add(new TourGuideModel("Rey Manigos", R.mipmap.ic_launcher, "Your lovely companion :) ", 5, "17"));
////
////        return tourguideList;
////    }
//
//
//    public static void setPosition(int position2){
//        positionwew = position2;
//    }
//    public static int getPosition(){
//        return positionwew;
//    }
//
//
//
//}
