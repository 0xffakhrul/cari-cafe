package com.example.cafe;

public class DynamicRvModel {

    private int cafeImage;
    private String cafeName;
    private String cafeLocation;
    private String cafePhone;
    private String cafeState;

    public DynamicRvModel(int cafeImage, String cafeName, String cafeLocation, String cafePhone, String cafeState) {
        this.cafeImage = cafeImage;
        this.cafeName = cafeName;
        this.cafeLocation = cafeLocation;
        this.cafePhone = cafePhone;
        this.cafeState = cafeState;
    }

    public int getCafeImage() {
        return cafeImage;
    }

    public String getCafeName() {
        return cafeName;
    }

    public String getCafeLocation() {
        return cafeLocation;
    }

    public String getCafePhone() {
        return cafePhone;
    }

    public String getCafeState() {
        return cafeState;
    }
}
