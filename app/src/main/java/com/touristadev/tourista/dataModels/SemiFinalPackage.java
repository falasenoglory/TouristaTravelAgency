package com.touristadev.tourista.dataModels;

/**
 * Created by Shanyl Jimenez on 2/28/2017.
 */

public class SemiFinalPackage {
    private TouristaPackages tpackage= new TouristaPackages();
    private double totalpoints;

    public SemiFinalPackage() {
    }

    public SemiFinalPackage(TouristaPackages tpackage) {
        this.tpackage = tpackage;
    }

    public SemiFinalPackage(TouristaPackages tpackage, double totalpoints) {
        this.tpackage = tpackage;
        this.totalpoints = totalpoints;
    }

    public TouristaPackages getTpackage() {
        return tpackage;
    }

    public void setTpackage(TouristaPackages tpackage) {
        this.tpackage = tpackage;
    }

    public double getTotalpoints() {
        return totalpoints;
    }

    public void setTotalpoints(double totalpoints) {
        this.totalpoints = totalpoints;
    }
}
