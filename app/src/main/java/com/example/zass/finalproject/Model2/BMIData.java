package com.example.zass.finalproject.Model2;

/**
 * Created by zass on 3/4/2019.
 */

public class BMIData {

    private String id;
    private String height;
    private String weight;

    public BMIData(){};

    public BMIData(String id, String height, String weight)
    {
        this.id=id;
        this.height=height;
        this.weight=weight;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
    public String getWeight()
    {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
