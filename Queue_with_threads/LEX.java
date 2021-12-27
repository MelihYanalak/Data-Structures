package com.company;

import java.util.Comparator;

public class LEX implements Comparator<Pixel> {
    @Override
    public int compare(Pixel o1, Pixel o2) {
        if (o1.getRed() == o2.getRed()){
            if (o1.getGreen() == o2.getGreen()){
                return (o1.getBlue() - o2.getBlue());
            }
            else {
                return (o1.getGreen() - o2.getGreen());
            }

        }
        else {
            return (o1.getRed() - o2.getRed());
        }
    }
    public LEX(){}
}
