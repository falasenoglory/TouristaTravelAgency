package com.touristadev.tourista.controllers;

import android.util.Log;

import com.touristadev.tourista.dataModels.TGAcceptance;
import com.touristadev.tourista.dataModels.TGRating;
import com.touristadev.tourista.dataModels.TourGuide;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 2/27/2017.
 */

public class ControllerAlgorithims {

    /////// STATIC VARIABLE /////////////////////////////////////////
    public static TourGuide CurrentTG;
    static ArrayList<TourGuide> TourGuideList = new ArrayList<>();
    private ArrayList<TGRating> tgRating1 = new ArrayList<>();
    private ArrayList<TGRating> tgRating2 = new ArrayList<>();
    private ArrayList<TGRating> tgRating3 = new ArrayList<>();
    private ArrayList<TGRating> tgRating4 = new ArrayList<>();
    private ArrayList<TGRating> tgRating5 = new ArrayList<>();
    private ArrayList<TGRating> tgRating6 = new ArrayList<>();
    private ArrayList<TGRating> tgRating7 = new ArrayList<>();
    private ArrayList<TGRating> tgRating8 = new ArrayList<>();
    private ArrayList<TGRating> tgRating9 = new ArrayList<>();
    private ArrayList<TGRating> tgRating10 = new ArrayList<>();

    TGRating rt;
    /////// STATIC VARIABLE /////////////////////////////////////////

    private static int positionwew;
    private static boolean tourguidemode;


    public void Controllers() {

        Log.d("pan", " 2");
        double rt1 = 0, rt2 = 0, rt3 = 0, rt4 = 0, rt5 = 0, rt6 = 0, rt7 = 0, rt8 = 0, rt9 = 0, rt10 = 0;

        /// <TOURGUIDE> ///////////////////////////////////////////////////////////////////////

        /// </Rating>
        tgRating1.add(new TGRating(5, 5, 5));
        tgRating1.add(new TGRating(5, 5, 5));
        tgRating1.add(new TGRating(5, 5, 5));
        tgRating1.add(new TGRating(5, 5, 5));
        tgRating1.add(new TGRating(5, 5, 5));
        tgRating1.add(new TGRating(5, 5, 5));
        tgRating1.add(new TGRating(5, 5, 5));
        tgRating1.add(new TGRating(5, 5, 5));
        tgRating1.add(new TGRating(5, 5, 5));
        tgRating1.add(new TGRating(5, 5, 5));

        for (int i = 0; i < tgRating1.size(); i++) {
            rt = tgRating1.get(i);
            rt1 += (rt.getIsKnowledgeable() * .40) + (rt.getHasTheRightPersonality() * .30) + (rt.getActsProfessionally() * .30);
        }
        rt1 = (rt1 / tgRating1.size()) / 5 * 100;

        Log.d("pan", tgRating1.toString() + "d");

        tgRating2.add(new TGRating(4, 4, 3));
        tgRating2.add(new TGRating(4, 4, 3));
        tgRating2.add(new TGRating(4, 4, 3));
        tgRating2.add(new TGRating(4, 5, 5));
        tgRating2.add(new TGRating(5, 5, 4));
        tgRating2.add(new TGRating(5, 5, 4));
        tgRating2.add(new TGRating(5, 5, 4));
        tgRating2.add(new TGRating(4, 4, 4));
        tgRating2.add(new TGRating(4, 4, 4));
        tgRating2.add(new TGRating(4, 4, 4));

        for (int i = 0; i < tgRating2.size(); i++) {
            rt = tgRating2.get(i);
            rt2 += (rt.getIsKnowledgeable() * .40) + (rt.getHasTheRightPersonality() * .30) + (rt.getActsProfessionally() * .30);
        }
        rt2 = (rt2 / tgRating2.size()) / 5 * 100;

        Log.d("pan", tgRating2.toString() + "d");

        tgRating3.add(new TGRating(4, 2, 3));
        tgRating3.add(new TGRating(4, 2, 3));
        tgRating3.add(new TGRating(4, 2, 3));
        tgRating3.add(new TGRating(4, 5, 5));
        tgRating3.add(new TGRating(4, 5, 4));
        tgRating3.add(new TGRating(4, 5, 4));
        tgRating3.add(new TGRating(4, 5, 4));
        tgRating3.add(new TGRating(4, 4, 4));
        tgRating3.add(new TGRating(4, 4, 4));
        tgRating3.add(new TGRating(4, 4, 4));

        for (int i = 0; i < tgRating3.size(); i++) {
            TGRating rt = tgRating3.get(i);
            rt3 += (rt.getIsKnowledgeable() * .40) + (rt.getHasTheRightPersonality() * .30) + (rt.getActsProfessionally() * .30);
        }
        rt3 = (rt3 / tgRating3.size()) / 5 * 100;

        Log.d("pan", tgRating3.toString() + "d");

        tgRating4.add(new TGRating(5, 2, 3));
        tgRating4.add(new TGRating(5, 2, 3));
        tgRating4.add(new TGRating(5, 2, 3));
        tgRating4.add(new TGRating(5, 5, 5));
        tgRating4.add(new TGRating(5, 5, 4));
        tgRating4.add(new TGRating(5, 5, 4));
        tgRating4.add(new TGRating(4, 5, 4));
        tgRating4.add(new TGRating(4, 4, 4));
        tgRating4.add(new TGRating(4, 4, 4));
        tgRating4.add(new TGRating(4, 4, 4));

        for (int i = 0; i < tgRating4.size(); i++) {
            TGRating rt = tgRating4.get(i);
            rt4 += (rt.getIsKnowledgeable() * .40) + (rt.getHasTheRightPersonality() * .30) + (rt.getActsProfessionally() * .30);
        }
        rt4 = (rt4 / tgRating4.size()) / 5 * 100;

        Log.d("pan", tgRating4.toString() + "d");

        tgRating5.add(new TGRating(5, 5, 5));
        tgRating5.add(new TGRating(5, 5, 5));
        tgRating5.add(new TGRating(5, 5, 5));
        tgRating5.add(new TGRating(5, 5, 5));
        tgRating5.add(new TGRating(5, 5, 5));
        tgRating5.add(new TGRating(5, 5, 5));
        tgRating5.add(new TGRating(5, 5, 5));
        tgRating5.add(new TGRating(5, 5, 5));
        tgRating5.add(new TGRating(5, 5, 5));
        tgRating5.add(new TGRating(5, 5, 5));

        for (int i = 0; i < tgRating5.size(); i++) {
            TGRating rt = tgRating5.get(i);
            rt5 += (rt.getIsKnowledgeable() * .40) + (rt.getHasTheRightPersonality() * .30) + (rt.getActsProfessionally() * .30);
        }
        rt5 = (rt5 / tgRating5.size()) / 5 * 100;

        Log.d("pan", tgRating5.toString() + "d");

        tgRating6.add(new TGRating(5, 5, 1));
        tgRating6.add(new TGRating(5, 5, 1));
        tgRating6.add(new TGRating(5, 5, 1));
        tgRating6.add(new TGRating(5, 5, 1));
        tgRating6.add(new TGRating(5, 5, 1));
        tgRating6.add(new TGRating(5, 5, 1));
        tgRating6.add(new TGRating(5, 5, 1));
        tgRating6.add(new TGRating(5, 5, 1));
        tgRating6.add(new TGRating(5, 5, 1));
        tgRating6.add(new TGRating(5, 5, 1));

        for (int i = 0; i < tgRating6.size(); i++) {
            TGRating rt = tgRating6.get(i);
            rt6 += (rt.getIsKnowledgeable() * .40) + (rt.getHasTheRightPersonality() * .30) + (rt.getActsProfessionally() * .30);
        }
        rt6 = (rt6 / tgRating6.size()) / 5 * 100;

        Log.d("pan", tgRating6.toString() + "d");

        tgRating7.add(new TGRating(3, 3, 3));
        tgRating7.add(new TGRating(3, 3, 3));
        tgRating7.add(new TGRating(3, 3, 3));
        tgRating7.add(new TGRating(3, 3, 5));
        tgRating7.add(new TGRating(3, 3, 4));
        tgRating7.add(new TGRating(3, 3, 4));
        tgRating7.add(new TGRating(4, 5, 4));
        tgRating7.add(new TGRating(4, 4, 4));
        tgRating7.add(new TGRating(4, 4, 4));
        tgRating7.add(new TGRating(4, 4, 4));

        for (int i = 0; i < tgRating7.size(); i++) {
            TGRating rt = tgRating7.get(i);
            rt7 += (rt.getIsKnowledgeable() * .40) + (rt.getHasTheRightPersonality() * .30) + (rt.getActsProfessionally() * .30);
        }
        rt7 = (rt7 / tgRating7.size()) / 5 * 100;

        Log.d("pan", tgRating7.toString() + "d");

        tgRating8.add(new TGRating(4, 4, 4));
        tgRating8.add(new TGRating(4, 4, 4));
        tgRating8.add(new TGRating(4, 4, 4));
        tgRating8.add(new TGRating(4, 4, 4));
        tgRating8.add(new TGRating(4, 4, 4));
        tgRating8.add(new TGRating(4, 4, 4));
        tgRating8.add(new TGRating(4, 4, 4));
        tgRating8.add(new TGRating(4, 4, 4));
        tgRating8.add(new TGRating(4, 4, 4));
        tgRating8.add(new TGRating(4, 4, 4));

        for (int i = 0; i < tgRating8.size(); i++) {
            TGRating rt = tgRating8.get(i);
            rt8 += (rt.getIsKnowledgeable() * .40) + (rt.getHasTheRightPersonality() * .30) + (rt.getActsProfessionally() * .30);
        }
        rt8 = (rt8 / tgRating8.size()) / 5 * 100;

        Log.d("pan", tgRating8.toString() + "d");

        tgRating9.add(new TGRating(5, 4, 1));
        tgRating9.add(new TGRating(5, 4, 1));
        tgRating9.add(new TGRating(5, 4, 1));
        tgRating9.add(new TGRating(5, 4, 1));
        tgRating9.add(new TGRating(5, 4, 1));
        tgRating9.add(new TGRating(5, 4, 1));
        tgRating9.add(new TGRating(5, 4, 1));
        tgRating9.add(new TGRating(5, 4, 1));
        tgRating9.add(new TGRating(5, 4, 1));
        tgRating9.add(new TGRating(5, 4, 1));

        for (int i = 0; i < tgRating9.size(); i++) {
            TGRating rt = tgRating9.get(i);
            rt9 += (rt.getIsKnowledgeable() * .40) + (rt.getHasTheRightPersonality() * .30) + (rt.getActsProfessionally() * .30);
        }
        rt9 = (rt9 / tgRating9.size()) / 5 * 100;

        Log.d("pan", tgRating9.toString() + "d");

        tgRating10.add(new TGRating(5, 4, 5));
        tgRating10.add(new TGRating(5, 4, 5));
        tgRating10.add(new TGRating(5, 4, 5));
        tgRating10.add(new TGRating(5, 4, 5));
        tgRating10.add(new TGRating(5, 4, 5));
        tgRating10.add(new TGRating(5, 4, 5));
        tgRating10.add(new TGRating(5, 4, 2));
        tgRating10.add(new TGRating(5, 4, 2));
        tgRating10.add(new TGRating(5, 4, 2));
        tgRating10.add(new TGRating(5, 4, 2));

        for (int i = 0; i < tgRating10.size(); i++) {
            TGRating rt = tgRating10.get(i);
            rt10 += (rt.getIsKnowledgeable() * .40) + (rt.getHasTheRightPersonality() * .30) + (rt.getActsProfessionally() * .30);
        }
        rt10 = (rt10 / tgRating10.size()) / 5 * 100;

        /// </Rating>

        /// <Language>
        ArrayList<String> lang1 = new ArrayList<>();
        lang1.add("Filipino");
        lang1.add("English");
        lang1.add("Korean");

        ArrayList<String> lang2 = new ArrayList<>();
        lang2.add("Filipino");
        lang2.add("English");
        lang2.add("Nihongo");

        ArrayList<String> lang3 = new ArrayList<>();
        lang3.add("Filipino");
        lang3.add("English");

        ArrayList<String> lang4 = new ArrayList<>();
        lang4.add("Filipino");
        lang4.add("English");
        lang4.add("Indian");

        ArrayList<String> lang5 = new ArrayList<>();
        lang5.add("Filipino");
        lang5.add("English");
        lang5.add("French");
        lang5.add("Korean");

        ArrayList<String> lang6 = new ArrayList<>();
        lang6.add("Filipino");
        lang6.add("English");
        lang6.add("Korean");

        ArrayList<String> lang7 = new ArrayList<>();
        lang7.add("Filipino");
        lang7.add("English");
        lang7.add("Nihongo");

        ArrayList<String> lang8 = new ArrayList<>();
        lang8.add("English");
        lang8.add("French");
        lang8.add("Filipino");

        ArrayList<String> lang9 = new ArrayList<>();
        lang9.add("English");
        lang9.add("Filipino");

        ArrayList<String> lang10 = new ArrayList<>();
        lang10.add("Filipino");
        /// </Language>

        /// <Acceptance rating>
        TGAcceptance tga1 = new TGAcceptance(100, 100);
        double gentga1 = (tga1.getNoAccepted() / tga1.getNoRequest()) * 100;

        TGAcceptance tga2 = new TGAcceptance(100, 85);
        double gentga2 = (tga2.getNoAccepted() / tga2.getNoRequest()) * 100;

        TGAcceptance tga3 = new TGAcceptance(100, 90);
        double gentga3 = (tga3.getNoAccepted() / tga3.getNoRequest()) * 100;

        TGAcceptance tga4 = new TGAcceptance(100, 94);
        double gentga4 = (tga4.getNoAccepted() / tga4.getNoRequest()) * 100;

        TGAcceptance tga5 = new TGAcceptance(100, 99);
        double gentga5 = (tga5.getNoAccepted() / tga5.getNoRequest()) * 100;

        TGAcceptance tga6 = new TGAcceptance(100, 96);
        double gentga6 = (tga6.getNoAccepted() / tga6.getNoRequest()) * 100;

        TGAcceptance tga7 = new TGAcceptance(100, 89);
        double gentga7 = (tga7.getNoAccepted() / tga7.getNoRequest()) * 100;

        TGAcceptance tga8 = new TGAcceptance(100, 92);
        double gentga8 = (tga8.getNoAccepted() / tga8.getNoRequest()) * 100;

        TGAcceptance tga9 = new TGAcceptance(100, 87);
        double gentga9 = (tga9.getNoAccepted() / tga9.getNoRequest()) * 100;

        TGAcceptance tga10 = new TGAcceptance(100, 88);
        double gentga10 = (tga10.getNoAccepted() / tga10.getNoRequest()) * 100;

    }
        /// </Acceptance rating>
//
//            TourGuideList.add(new TourGuide("1","1","","","","Nicolas","James","Chiong","Hello","09420953342"
//                    ,"","Filipino","Cebu","","","",rt1,gentga1,tga1,lang1,tgRating1,false,0));
//            TourGuideList.add(new TourGuide("2","2","","","","Lilo","Nicole","Perez","Hello","09420953342"
//                    ,"","Filipino","Manila","","","",rt2,gentga2,tga2,lang2,tgRating2,false,0));
//            TourGuideList.add(new TourGuide("3","3","","","","Justine","Yrvin","Boholst","Hello","09420953342"
//                    ,"","Filipino","Bohol","","","",rt3,gentga3,tga3,lang3,tgRating3,false,0));
//            TourGuideList.add(new TourGuide("4","4","","","","Malbor","Fortune","Mighty","Hello","09420953342"
//                    ,"","Filipino","Manila","","","",rt4,gentga4,tga4,lang4,tgRating4,false,0));
//            TourGuideList.add(new TourGuide("5","5","","","","Shanyl","Mancao","Jimenez","Hello","09420953342"
//                    ,"","Filipino","Cebu","","","",rt5,gentga5,tga5,lang5,tgRating5,false,0));
//        TourGuideList.add(new TourGuide("Christian","Cagayan",rt6,gentga6,tga6,lang6,tgRating6,false,0));
//        TourGuideList.add(new TourGuide("Rey","Cagayan",rt7,gentga7,tga7,lang7,tgRating7,false,0));
//        TourGuideList.add(new TourGuide("Margot","Cebu",rt8,gentga8,tga8,lang8,tgRating8,false,0));
//        TourGuideList.add(new TourGuide("Blessy","Negros",rt9,gentga9,tga9,lang9,tgRating9,false,0));
//        TourGuideList.add(new TourGuide("Margarette","Palawan",rt10,gentga10,tga10,lang10,tgRating10,false,0));


        /// </TOURGUIDES> //////////////////////////////////////////////////////////////////////////////////

//        activities0.add("Swimming");
//
//        categories0.add(new Categories("Beaches and Resorts"));
//        categories0.add(new Categories("Nature"));
//
//        tribes0.add(new Tribes("Comformist"));
//        tribes0.add(new Tribes("Thrill- Seeker"));
//        tribes0.add(new Tribes("Self- Improver"));
//        spotList.clear();
//
//        spotList.add(new Spots(0,"Masters Resort Cebu","4044 Oslob, Cebu, Philippines",
//                "8:00","21:00","The southern part of the province is one of the areas where you can enjoy various sorts of seawater activities, do adventurous trips, have fun and cherish the tranquil ambiance and surroundings."
//                ,"2000","9.459556960067692","123.37731275707483",
//                activities0,categories0,tribes0,4, R.mipmap.spot_oslobwhalshark));
//
//        // SPOT ////////////////////////////////////////////////////////////////////////////////////
//
//        ArrayList<String> activities0 = new ArrayList<>();
//        ArrayList<Categories> categories0 = new ArrayList<>();
//        ArrayList<Tribes> tribes0 = new ArrayList<>();
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
//        spotList.add(new Spots(1,"Oslob Whale Shark Watching","Tan-awan Oslob, Cebu, Ph",
//                "8:00","12:00","Oslob Whalesharks watching was born to give information about whale shark interaction in Oslob, we are here to organize day tour trips on whale shark encounters with side trip to Tumalog waterfalls. We"
//                ,"1000","9.47008451293314","123.38275127112864",
//                activities1,categories1,tribes1,4,R.mipmap.spot_mst));
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
//        spotList.add(new Spots(2,"Basilica del Santo Niño","Santo Nino Chapel Lane, Cebu City, Cebu"
//                ,"5:00","20:00","The oldest Roman Catholic church in the country, it is built on the spot where the image of the Santo Niño de Cebú was found during the expedition of Miguel López de Legazpi. "
//                ,"100","10.294194","123.902106",
//                activities2,categories2,tribes2,4,R.mipmap.stnino));
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
//        spotList.add(new Spots(3, "Museo Sugbo", "M. J. Cuenco Ave, Cebu City, 6000 Cebu",
//                "9:00","17:30","Museo Sugbo is the Cebu Provincial Museum located in the former Cebu Provincial Detention and Rehabilitation Center, four blocks from Plaza Independencia."
//                ,"100", "10.303781",  "123.906758",
//                activities3,categories3,tribes3,4,R.mipmap.msugbo));

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
//        spotList.add( new Spots(4,"Fort San Pedro", "A. Pigafetta Street, Cebu City, 6000"
//                ,"7:00", "19:00", "One of the city’s historical attractions is Fort San Pedro which is known as the smallest and oldest fort in the Philippines.",
//                "100","10.292499","123.905828",activities4, categories4, tribes4,4,R.mipmap.fsanpedro));
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
//        spotList.add(new Spots(5,"Tumalog Falls","Cebu South Rd, Oslob, Cebu",
//                "5:00","22:00","Tumalog Falls (also called the “Toslob Falls” or “Mag-ambak Falls”) is situated in the town of Oslob, Cebu. It is just about 15-20 minutes ride from the whale-watching site.",
//                "500","9.486560"," 123.369264",activities5,categories5,tribes5,54,R.mipmap.tml));
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
//        spotList.add(new Spots(6,"Kawasan Falls","Matutinao,, Badian, 6031 Cebu",
//                "5:00","22:00","Cebu kawasan falls Cebu is a peaceful natural place where you can enjoy many waterfalls of natural spring water located near the southern tip of Cebu Philippines.. A gentle hush of rushing ice cool water."
//                , "1000","9.811219", "123.374875",activities6,categories6,tribes6,4,R.mipmap.kws));
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
//        spotList.add(new Spots(7,"Intrauros","Bonifacio Dr & Padre Burgos St, Manila, Luzon 1002, Philippines",
//                "8:00 AM","10:00 PM","Intramuros is the oldest district and historic core of Manila, Philippines. ... Map of Metro Manila showing the location of Intramuros."
//                , "1000","9.811219", "123.374875",activities6,categories6,tribes6,4,R.mipmap.kws));


//    }


    public String getRecommendedTG(String location, String language) {
        Controllers();
        String output = "";
        TourGuide tgthis = new TourGuide();

        for (int i = 0; i < TourGuideList.size(); i++) {
            output = output + "\n\nTourGuide#: " + i;
            output = output + "\nName:" + TourGuideList.get(i).getTGfirstName() + " " + TourGuideList.get(i).getTGlastName();
            output = output + "\nGen. Rating:" + TourGuideList.get(i).getGenAllRating();
            output = output + "\n Acceptance Rating:" + TourGuideList.get(i).getGenAcceptanceRating();
            output = output + "\n No. of priority leeway:" + TourGuideList.get(i).getTGcountPriority();
            output = output + "\n Total Rating:" + (TourGuideList.get(i).getGenAllRating() * .50 + TourGuideList.get(i).getGenAcceptanceRating() * .50);
            output = output + "\n Location:" + TourGuideList.get(i).getTGCity();
            //1. check for location
            if (TourGuideList.get(i).getTGCity() == location) {
                //2. check for language
                for (int j = 0; j < TourGuideList.get(i).getTGLanguages().size(); j++) {
                    output = output + "\n Languages:" + TourGuideList.get(i).getTGLanguages().get(j);
                    if (TourGuideList.get(i).getTGLanguages().get(j) == language)
                        if (TourGuideList.get(i).getTGcountPriority() == 0) {
                            tgthis = TourGuideList.get(i);
                        } else if (TourGuideList.get(i).getTGcountPriority() > tgthis.getTGcountPriority()) {

                            tgthis = TourGuideList.get(i);
                        } else {
                            // 3. Check highest Ranking
                            if ((TourGuideList.get(i).getGenAllRating() * .50 + TourGuideList.get(i).getGenAcceptanceRating() * .50) >
                                    (tgthis.getGenAllRating() * .50 + tgthis.getGenAcceptanceRating() * .50))
                                tgthis = TourGuideList.get(i);
                        }
                }
            }
        }

        output = output + "\n\nWinner:" + tgthis.getTGfirstName() + " " + tgthis.getTGlastName();
        return output;

    }


//    public static ArrayList<TouristaPackages> getSuggestedPackages(TouristaPackages pa, ArrayList<TouristaPackages> allTourPackages)
//    {
//        ArrayList<TouristaPackages> FinalPackageList = new ArrayList<>(); // this is for the final recommendation;
//        ArrayList<SemiFinalPackage> SemiPackageList = new ArrayList<>(); // this is for the semi final recommendation. subject for testing sa noOfFriends
//
//        RatingRange RatingRange= new RatingRange();
//        PriceRange PriceRange= new PriceRange();
//        ArrayList<String> TravelAgencySet= new ArrayList<>();
//        ArrayList<String> CategorySet= new ArrayList<>();
//
//
//        // <ITEM SET STANDARDS> /////////////////////////////////////
//        ArrayList<String> rt= new ArrayList<>();
//        rt.add("0-1");
//        rt.add("1-2");
//        rt.add("2-3");
//        rt.add("3-4");
//        rt.add("4-5");
//
//        ArrayList<String> pr= new ArrayList<>();
//        pr.add("Top");
//        pr.add("Upper Middle");
//        pr.add("Middle");
//        pr.add("Bottom");
//
//        ArrayList<ArrayList<String>> ta= new ArrayList<>();
//
//                    //First ItemSet for Travel Agency
//                    ArrayList<String> ta1= new ArrayList<>();
//                    ta1.add("USJR");
//                    ta1.add("Jimbofer");
//                    ta1.add("Colt");
//
//                    //Second ItemSet for Travel Agency
//                    ArrayList<String> ta2= new ArrayList<>();
//                    ta2.add("WOW Travel and Tours");
//                    ta2.add("Cebu Fortune Travel");
//                    ta2.add("AAir You Go Travel");
//
//                    //Third ItemSet for Travel Agency
//                    ArrayList<String> ta3= new ArrayList<>();
//                    ta3.add("Land and Sky Travel");
//                    ta3.add("Cebu Holidays Tours");
//                    ta3.add("Southwind Travel and Tours");
//
//        ta.add(ta1);
//        ta.add(ta2);
//        ta.add(ta3);
//
//        ArrayList<ArrayList<String>> cat= new ArrayList<>();
//
//        ArrayList<String> cat1= new ArrayList<>();
//        cat1.add("Family Tours");
//        cat1.add("Special Event Tours");
//        cat1.add("Adventure Tours");
//        cat1.add("Honeymoon Tours");
//
//        ArrayList<String> cat2= new ArrayList<>();
//        cat2.add("Religious Tours");
//        cat2.add("Educational Tours");
//        cat2.add("National Park Tours");
//        cat2.add("Cultural Tours");
//
//        // </ITEM SET STANDARDS> /////////////////////////////////////
//
//
//
//        // For HomePage
//        // Make test item sets (most frequent in history):
//        //  Rating, Category, Travel Agency, Price Range
//
//        // 1.Get the rating range
//            if(pa.getRating()>0 && pa.getRating()<=1)
//            {
//                RatingRange=new RatingRange(0,1);
//            }
//            else if(pa.getRating()>1 && pa.getRating()<=2)
//            {
//                RatingRange=new RatingRange(1,2);
//            }
//            else if(pa.getRating()>2 && pa.getRating()<=3)
//            {
//                RatingRange=new RatingRange(2,3);
//            }
//            else if(pa.getRating()>3 && pa.getRating()<=4)
//            {
//                RatingRange=new RatingRange(3,4);
//            }
//            else if(pa.getRating()>4 && pa.getRating()<=5)
//            {
//                RatingRange=new RatingRange(4,5);
//            }
//        // 2. Get price range
//
//            if(Integer.parseInt(pa.getPackPrice())>0 && Integer.parseInt(pa.getPackPrice())<=5000)
//            {
//                PriceRange = new PriceRange(0,5000);
//            }
//            else if(Integer.parseInt(pa.getPackPrice())>5000 && Integer.parseInt(pa.getPackPrice())<=10000)
//            {
//                PriceRange=new PriceRange(5000,10000);
//            }
//            else if(Integer.parseInt(pa.getPackPrice())>10000 && Integer.parseInt(pa.getPackPrice())<=15000)
//            {
//                PriceRange=new PriceRange(10000,15000);
//            }
//            else if(Integer.parseInt(pa.getPackPrice())>15000)
//            {
//                PriceRange=new PriceRange(15000,100000000);
//            }
//
//        // 3. Get ItemSet for Travel Agency
//
//        for(int i=0;i<ta.size();i++)
//        {
//            for (int a=0;a<ta.get(i).size();a++)
//            {
//                if(pa.getCompanyName().equals(ta.get(i).get(a)))
//                {
//                    TravelAgencySet=ta.get(i);
//                }
//                break;
//            }
//            break;
//        }
//
//        // 4. Get ItemSet for Category
//
//        for(int i=0;i<cat.size();i++)
//        {
//            for (int a=0;a<cat.get(i).size();a++)
//            {
//                if(pa.getCategory().equals(cat.get(i).get(a)))
//                {
//                    CategorySet=cat.get(i);
//                }
//                break;
//            }
//            break;
//        }
//
//        // 5. Get the recommendation list (ranked) according to the item set taken.
//
//        for(int b=0;b<allTourPackages.size();b++)
//        {
//            // Rating range
//            if(allTourPackages.get(b).getRating()>RatingRange.getStart()&&allTourPackages.get(b).getRating()<=RatingRange.getEnd())
//            {
//                // Price Range
//                if(Integer.parseInt(allTourPackages.get(b).getPackPrice())>PriceRange.getPriceStart() && Integer.parseInt(allTourPackages.get(b).getPackPrice()) <= PriceRange.getPriceEnd())
//                {
//
//                    //  itemSet for Category. Check if pasok sa itemset
//                    for(int c=0;c<CategorySet.size();c++)
//                    {
//                        if(allTourPackages.get(b).getCategory().equals(CategorySet.get(c)))
//                        {
//                            //  itemSet for Travel. Check if pasok sa itemSet then sulod sa SemiPackageList
//                            for(int d=0;d<CategorySet.size();d++)
//                            {
//                                if(allTourPackages.get(b).getCompanyName().equals(TravelAgencySet.get(d)))
//                                {
//                                    SemiPackageList.add(new SemiFinalPackage(allTourPackages.get(b)));
//                                }
//                            }
//                        }
//                    }
//
//
//                }
//            }
//
//        }
//
//        double differenceSaLocation=0;
//        // 6. Calculate the points SemiPackageList
//        for(int e=0;e<SemiPackageList.size();e++)
//        {
//            TouristaPackages tp= SemiPackageList.get(e).getTpackage();
//            SemiPackageList.get(e).setTotalpoints(((tp.getNumberOfFreindsTakenThePackage()*0.50)+(differenceSaLocation*0.50)));
//        }
//
//
//        // 7. Sort SemiPackageList
//        SemiFinalPackage sp= new SemiFinalPackage();
//
//        for (int i = 0; i<SemiPackageList.size()-1; i++)
//        {
//            int min = i;
//            for (int j = i+1; j < SemiPackageList.size(); j++)
//            if (SemiPackageList.get(j).getTotalpoints()< SemiPackageList.get(min).getTotalpoints()) {
//                min = j;
//            }
//            sp = SemiPackageList.get(i);
//            SemiPackageList.set(i,SemiPackageList.get(min));
//            SemiPackageList.set(min,sp);
//        }
//
//        // 8. Transfer Clean SemiPackagelist to FinalPackageList
//        for (int i=0;i<SemiPackageList.size();i++)
//        {
//            FinalPackageList.add(SemiPackageList.get(i).getTpackage());
//        }
//
//
//        // For Selected Package
//        // 1. Identify item set (base from current package/spot)
//        // Package: Rating, Category, Travel Agency, Price Range , City
//        // 2. Consider no of Friends taken the package
//
//        // For Selected Spots
//        // 1. Identify item set (base from current package/spot)
//        // Package: Rating, Category, Travel Agency, Prince
//        // 2. Consider no of Friends
//        // 3. Consider nearest to the Spot Location
//
//
//        return FinalPackageList;
//    }
//



//        public ArrayList<Categories> getControllerCategories()
//        {
//            Controllers();
//            ArrayList<Categories> L= new ArrayList<>();
//            L.add(new Categories("Adventure"));
//            L.add(new Categories("Aquaria"));
//            L.add(new Categories("Art Galleries"));
//            L.add(new Categories("Bar"));
//            L.add(new Categories("Beaches and Resorts"));
//            L.add(new Categories("Building and Structure"));
//            L.add(new Categories("Camping"));
//            L.add(new Categories("Church"));
//            L.add(new Categories("Historical"));
//            L.add(new Categories("Hotels"));
//            L.add(new Categories("Museums"));
//            L.add(new Categories("Nature"));
//            L.add(new Categories("Night Clubs"));
//            L.add(new Categories("Restaurants"));
//            L.add(new Categories("Sports"));
//            L.add(new Categories("Zoo"));
//            return L;
//        }
//
//        public ArrayList<Tribes> getControllerTribes()
//        {   Controllers();
//            ArrayList<Tribes> L = new ArrayList<>();
//
//            L.add(new Tribes("Thrill-Seeker"));
//            L.add(new Tribes("Collector"));
//            L.add(new Tribes("Conformist"));
//            L.add(new Tribes("Escapist"));
//            L.add(new Tribes("The Self-Improver"));
//            L.add(new Tribes("Pilgrim"));
//            L.add(new Tribes("The Pioner"));
//            L.add(new Tribes("The Occasional"));
//            L.add(new Tribes("Genuinely Curious"));
//
//            return L;
//        }
//
//        public ArrayList<Spots>  getControllerSpots()
//        {
//            Controllers();
//
//            return spotList;
//        }
//
//        public ArrayList<String> tourGuideClassification()
//        {
//            ArrayList<String> L= new ArrayList<>();
//
//            L.add("Onsite");
//            L.add("Local");
//            L.add("City");
//            L.add("Staff");
//
//            return L;
//        }
//
//        public ArrayList<Packages> getControllerPackaaes()
//        {
//            Controllers();
//            ArrayList<Packages> L1= new ArrayList<>();
//            ArrayList<Categories> categories1 = new ArrayList<>();
//            ArrayList<Tribes> tribes1 = new ArrayList<>();
//            ArrayList<Itinerary> itineraries1 = new ArrayList<>();
//
//            ArrayList<Packages> L2= new ArrayList<>();
//            ArrayList<Categories> categories2 = new ArrayList<>();
//            ArrayList<Tribes> tribes2 = new ArrayList<>();
//            ArrayList<Itinerary> itineraries2 = new ArrayList<>();
//
//            ArrayList<Packages> L3= new ArrayList<>();
//            ArrayList<Categories> categories3 = new ArrayList<>();
//            ArrayList<Tribes> tribes3 = new ArrayList<>();
//            ArrayList<Itinerary> itineraries3 = new ArrayList<>();
//
//
//            /// PACKAGE ////////////////////////////////////////////////////////////////////////////////
//
//            categories1.add(new Categories("Adventure"));
//            categories1.add(new Categories("Nature"));
//            categories1.add(new Categories("Beaches and Resorts"));
//            categories1.add(new Categories("Beaches and Resorts"));
//
//            tribes1.add(new Tribes("Thrill-seeker"));
//            tribes1.add(new Tribes("Backpacker"));
//            tribes1.add(new Tribes("Escapist"));
//
//            itineraries1.add(new Itinerary("Pick up location","05:00","08:00"));
//            itineraries1.add(new Itinerary(spotList.get(1).getSpotName(),"08:00","11:00"));
//            itineraries1.add(new Itinerary("Lunch","11:00","13:00"));
//            itineraries1.add(new Itinerary(spotList.get(0).getSpotName(),"13:00","16:00"));
//
//            L1.add(new Packages("South Cebu Tours","Golden Sky Travel and Tours Corp",categories1,itineraries1,"Local",tribes2,4,2,8,R.mipmap.spot_cebusouthtour));
//
//            /// PACKAGE ////////////////////////////////////////////////////////////////////////////////
//
//
//            categories2.add(new Categories("Art Galleries"));
//            categories2.add(new Categories("Church"));
//            categories2.add(new Categories("Historical"));
//            categories2.add(new Categories("Museums"));
//
//            tribes2.add(new Tribes("Collector"));
//            tribes2.add(new Tribes("Escapist"));
//            tribes2.add(new Tribes("The Self-Improver"));
//            tribes2.add(new Tribes("Pilgrim"));
//            tribes2.add(new Tribes("Genuinely Curious"));
//
//            itineraries2.add(new Itinerary("Pick up location","06:00","09:00"));
//            itineraries2.add(new Itinerary(spotList.get(2).getSpotName(),"09:00","12:00"));
//            itineraries2.add(new Itinerary("Lunch","12:00","13:00"));
//            itineraries2.add(new Itinerary(spotList.get(3).getSpotAddress(),"13:00","15:00"));
//            itineraries2.add(new Itinerary(spotList.get(4).getSpotName(),"15:00","17:00"));
//
//            L2.add(new Packages("Cebu Pilgrimage","Fiesta Tours And Travel",categories2,itineraries2,"Local",tribes2,4,3,8,R.mipmap.spot_stonino));
//
//
//            /// PACKAGE ////////////////////////////////////////////////////////////////////////////////
//
//
//
//            categories3.add(new Categories("Adventure"));
//            categories3.add(new Categories("Aquaria"));
//            categories3.add(new Categories("Nature"));
//
//            tribes3.add(new Tribes("Thrill-Seeker"));
//            tribes3.add(new Tribes("Escapist"));
//            tribes3.add(new Tribes("The Self-Improver"));
//            tribes3.add(new Tribes("Genuinely Curious"));
//
//            itineraries3.add(new Itinerary("Pick up location","05:00","08:00"));
//            itineraries3.add(new Itinerary(spotList.get(1).getSpotName(),"08:00","08:30"));
//            itineraries3.add(new Itinerary("Short briefing then proceed to Whale Shark Watching / Snorkelin","08:30","11:00"));
//            itineraries3.add(new Itinerary("Lunch","11:00","12:00"));
//            itineraries3.add(new Itinerary(spotList.get(5).getSpotName(),"12:00","15:00"));
//            itineraries3.add(new Itinerary("Departure Time","15:00","17:00"));
//
//            L3.add(new Packages("Oslob Whale Watching","WOW Philippines Travel Agency, Inc.",categories3,itineraries3,"Local",tribes3,4,2,12,R.mipmap.spot_oslobwhalshark));
//
//            /// PACKAGE ////////////////////////////////////////////////////////////////////////////////
//
//            packageList.clear();
//            packageList.add(L1.get(0));
//            packageList.add(L2.get(0));
//            packageList.add(L3.get(0));
//
//
//            return packageList;
//        }
//


//
//        public void addBookedPackages(Packages pa)
//        {
//            BookedList.add(pa);
//            WishList.remove(pa);
//
//        }
//        public void addRequestPackage(Packages pa)
//        {
//            BookedList.add(pa);
//
//        }
//        public void addWishPackages(Packages pa)
//        {
//            WishList.add(pa);
//
//        }
//        public void addUser(FirebaseUser us)
//        {
//            user = us;
//
//
//        }public FirebaseUser getUser()
//        {
//
//            return user;
//
//        }
//
//        public void removeWishPackage(int pos)
//        {
//            WishList.remove(pos);
//
//        }
//        public void removeBookedPackages(int pos)
//        {
//            BookedList.remove(pos);
//
//        }
//        public void removeRequestPackage(int pos)
//        {
//            RequestList.remove(pos);
//
//        }
//        public ArrayList<Packages> getBookedList()
//        {
//
//
//            return BookedList;
//
//        }
//        public ArrayList<Packages> getRequestList()
//        {
//
//            return RequestList;
//
//        }
//        public ArrayList<Packages> getWishList()
//        {
//            return WishList;
//        }
//
//
//        public ArrayList<TourRequest> getTourRequestNew()
//        {
//            ArrayList<TourRequest> temp= new ArrayList<>();
////        for (int i=0;i<WishList.size();i++)
////        {
////            temp.add(new TourRequest("Nick Nicolas Chiong", "December 8, 2016",3,WishList.get(i),"Medium"));
////        }
//            return temp;
//        }
//        public static void setPosition(int position2){
//            positionwew = position2;
//        }
//        public int getPosition(){
//            return positionwew;
//        }
//
//        public static boolean isTourguidemode() {
//            return tourguidemode;
//        }
//
//        public static void setTourguidemode(boolean tourguidemode) {
//            Controllers.tourguidemode = tourguidemode;
//        }

        public  ArrayList<TourGuide> getTourGuideList()
        {
            return TourGuideList;
        }

        public  void addTourGuideList(TourGuide tg) {
            TourGuideList .add(tg);
        }
}
