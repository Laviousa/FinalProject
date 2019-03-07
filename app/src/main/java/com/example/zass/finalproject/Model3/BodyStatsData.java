package com.example.zass.finalproject.Model3;

/**
 * Created by zass on 3/4/2019.
 */

public class BodyStatsData {

    private String id;
    private String weight;
    private String height;
    private String BMI;
    private String waist;
    private String bodyFat;
    private String chest;
    private String arm;

    public BodyStatsData(){};

    public BodyStatsData(String id, String weight,String height,String BMI,String waist, String bodyFat,String chest, String arm)
    {
        this.id=id;
        this.weight=weight;
        this.height=height;
        this.BMI=BMI;
        this.waist=waist;
        this.bodyFat=bodyFat;
        this.chest=chest;
        this.arm=arm;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getArm() {
        return arm;
    }

    public void setArm(String arm) {
        this.arm = arm;
    }

    public String getBMI() {
        return BMI;
    }

    public void setBMI(String BMI) {
        this.BMI = BMI;
    }

    public String getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(String bodyFat) {
        this.bodyFat = bodyFat;
    }

    public String getChest() {
        return chest;
    }

    public void setChest(String chest) {
        this.chest = chest;
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

}
