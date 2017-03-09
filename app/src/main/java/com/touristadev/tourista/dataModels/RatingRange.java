package com.touristadev.tourista.dataModels;

/**
 * Created by Shanyl Jimenez on 2/28/2017.
 */

public class RatingRange {
    private double start;
    private double end;

    public RatingRange() {
    }

    public RatingRange(double start, double end) {
        this.start = start;
        this.end = end;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getEnd() {
        return end;
    }

    public void setEnd(double end) {
        this.end = end;
    }
}
