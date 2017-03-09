package com.touristadev.tourista.dataModels;

/**
 * Created by Shanyl Jimenez on 1/19/2017.
 */

public class TGAcceptance {

    private double noRequest;
    private double noAccepted;

    public TGAcceptance() {
    }

    public TGAcceptance(int noRequest, int noAccepted) {
        this.noRequest = noRequest;
        this.noAccepted = noAccepted;
    }

    public double getNoRequest() {
        return noRequest;
    }

    public void setNoRequest(double noRequest) {
        this.noRequest = noRequest;
    }

    public double getNoAccepted() {
        return noAccepted;
    }

    public void setNoAccepted(double noAccepted) {
        this.noAccepted = noAccepted;
    }
}
