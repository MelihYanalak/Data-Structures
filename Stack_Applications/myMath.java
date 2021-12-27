package com.company;

public class myMath {
    public static int factorial(int x){
        int result = 1;
        if (x == 0){
            return 1;
        }
        while (x > 0){
            result = result*x;
            x--;
        }
        return result;
    }



    public static double pow(double num,double exponent){
        if (exponent == 0){
            return 1;
        }
        else {
            double result = 1;
            while (exponent > 0){
                result = result*num;
                exponent--;
            }
            return result;
        }
    }
    public static double sin(double degree){
        degree %= 360;
        double radian = (degree/180)*(3.14159265359);
        double result = radian;
        int i = 1;
        while(i < 7) {
            if (i % 2 == 0) {
                result += pow(radian, 2 * i + 1) / (factorial(2 * i + 1));
            }
            else {
                result -= pow(radian, 2 * i + 1) / (factorial(2 * i + 1));
            }
            i++;
        }
        return (result);
    }
    public static double cos(double degree){
        degree = degree%360;
        double radian = degree*1./180.*(3.14159265359);
        double result = 1;
        int i = 1;
        while(i < 7) {
            if (i % 2 == 0) {
                result += pow(radian, 2 * i ) / factorial(2 * i );
            }
            else {
                result -= pow(radian, 2 * i ) / factorial(2 * i );
            }
            i++;
        }
        return (result);
    }
    public static double abs(double num){
        return (num >= 0)?num:((-1)*num);
    }
}
