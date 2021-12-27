package com.company;

public class Pixel {
    private int red;
    private int green;
    private int blue;

    public Pixel(int red,int green,int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }

    public int getRed() {
        return red;
    }
}
