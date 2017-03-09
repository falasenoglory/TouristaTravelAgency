package com.touristadev.tourista.dataModels;

/**
 * Created by Christian on 2/20/2017.
 */

public class listViewPackItinerary {
    private String name;
    private int Image;
    private String packagePos;

    public listViewPackItinerary(String name, int image, String packagePos) {
        this.name = name;
        Image = image;
        this.packagePos = packagePos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getPackagePos() {
        return packagePos;
    }

    public void setPackagePos(String packagePos) {
        this.packagePos = packagePos;
    }
}
