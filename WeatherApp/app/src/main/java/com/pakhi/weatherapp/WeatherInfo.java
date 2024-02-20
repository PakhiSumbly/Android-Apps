package com.pakhi.weatherapp;

import com.google.gson.annotations.SerializedName;

//this the wrapper class of MainData
public class WeatherInfo {

    @SerializedName("main")
    private MainData mainData;

    public MainData getMainData(){
        return mainData;
    }
}
