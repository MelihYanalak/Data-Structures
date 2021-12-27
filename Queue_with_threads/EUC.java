package com.company;

import java.util.Comparator;

public class EUC implements Comparator<Pixel> {
    @Override
    public int compare(Pixel o1, Pixel o2) {
        return ((o1.getGreen()*o1.getGreen() + o1.getRed()*o1.getRed() + o1.getBlue() * o1.getBlue()) - (o2.getGreen()*o2.getGreen() + o2.getRed()*o2.getRed() + o2.getBlue() * o2.getBlue()));
    }
    public EUC(){}
}
