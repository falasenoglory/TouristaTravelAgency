package com.touristadev.tourista.dataModels;

/**
 * Created by Shanyl Jimenez on 2/28/2017.
 */

public class PriceRange {
    private int priceStart;
    private int priceEnd;

    public PriceRange() {
    }

    public PriceRange(int priceStart, int priceEnd) {
        this.priceStart = priceStart;
        this.priceEnd = priceEnd;
    }

    public int getPriceStart() {
        return priceStart;
    }

    public void setPriceStart(int priceStart) {
        this.priceStart = priceStart;
    }

    public int getPriceEnd() {
        return priceEnd;
    }

    public void setPriceEnd(int priceEnd) {
        this.priceEnd = priceEnd;
    }
}
