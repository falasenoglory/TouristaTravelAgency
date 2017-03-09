package com.touristadev.tourista.formba;

import com.touristadev.tourista.dataModels.Itinerary;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 3/7/2017.
 */

public class Item {

    private int count;
    private ArrayList<Itinerary> Spot= new ArrayList<>();
    private int Support;

    public Item() {
    }

    public Item(int count, ArrayList<Itinerary> spot, int support) {
        this.count = count;
        Spot = spot;
        Support = support;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Itinerary> getSpot() {
        return Spot;
    }

    public void setSpot(ArrayList<Itinerary> spot) {
        Spot = spot;
    }

    public int getSupport() {
        return Support;
    }

    public void setSupport(int support) {
        Support = support;
    }
}
