package com.bbarg.bloodborneargentina.bbarg.Models;

public class Stat {

    private String name;
    private int value;
    private int minValue;
    private int maxValue;
    private String imageUri;


    public Stat(String name, int value, String imageUri) {
        this.name = name;
        this.value = value;
        this.minValue = 0;
        this.maxValue = 99;
        this.imageUri = imageUri;
    }

    public Stat(String name, int value, int minValue, int maxValue, String imageUri) {
        this.name = name;
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.imageUri = imageUri;
    }

    public Stat() {
        this.name = "";
        this.value = 0;
        this.minValue = 0;
        this.maxValue = 99;
        this.imageUri = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
}
