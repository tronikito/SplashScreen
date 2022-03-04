package com.example.splashscreen;

public class Bike {
    private String nameBike;
    private int imgBike;

    public Bike(String nameBike, int imgBike) {
        this.nameBike = nameBike;
        this.imgBike = imgBike;
    }

    public String getNameBike() {
        return nameBike;
    }

    public void setNameBike(String nameBike) {
        this.nameBike = nameBike;
    }

    public int getImgBike() {
        return imgBike;
    }

    public void setImgBike(int imgBike) {
        this.imgBike = imgBike;
    }
}
