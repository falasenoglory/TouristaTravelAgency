package com.touristadev.tourista.dataModels;

/**
 * Created by Shanyl Jimenez on 1/18/2017.
 */

public class TGRating {

    private double actsProfessionally;
//    1.Punctual
//    2.Organised
//    3.Sensitive to group needs
//    4.Prepared for medical emergencies

    private double isKnowledgeable;
//    1.Accurate
//    2.Multilingual
//    3.Knows audience

    private double hasTheRightPersonality;

//    1.Engaging
//    2.Leadership skills
//    3.Good sense of humour
//    4.Seeks feedback


    public TGRating() {
    }

    public TGRating(double actsProfessionally, double isKnowledgeable, double hasTheRightPersonality) {
        this.actsProfessionally = actsProfessionally;
        this.isKnowledgeable = isKnowledgeable;
        this.hasTheRightPersonality = hasTheRightPersonality;
    }

    public double getActsProfessionally() {
        return actsProfessionally;
    }

    public void setActsProfessionally(double actsProfessionally) {
        this.actsProfessionally = actsProfessionally;
    }

    public double getIsKnowledgeable() {
        return isKnowledgeable;
    }

    public void setIsKnowledgeable(double isKnowledgeable) {
        this.isKnowledgeable = isKnowledgeable;
    }

    public double getHasTheRightPersonality() {
        return hasTheRightPersonality;
    }

    public void setHasTheRightPersonality(double hasTheRightPersonality) {
        this.hasTheRightPersonality = hasTheRightPersonality;
    }
}
