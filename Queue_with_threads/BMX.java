package com.company;

import java.util.Comparator;

public class BMX implements Comparator<Pixel> {
    @Override
    public int compare(Pixel o1, Pixel o2) {
        return (compareBitmix(convertToBitmix(convertTo8(o1.getRed()),convertTo8(o1.getGreen()),convertTo8(o1.getBlue())),convertToBitmix(convertTo8(o2.getRed()),convertTo8(o2.getGreen()),convertTo8(o2.getBlue()))));
    }
    public int compareBitmix(char arr1[],char arr2[]){
        int i = 0;
        while (i < 24){
            if (arr1[i] == '1' && arr2[i] == '0' ){
                return 1;
            }
            if (arr1[i] == '0' && arr2[i] == '1' ){
                return -1;
            }
            i++;

        }
        return 0;
    }
    public  char[] convertTo8(int num){
        String str1 = Integer.toBinaryString(num);
        int count = 8-str1.length();
        int count2 = count;
        char arr1[] = new char[8];
        int i = 0;
        while (count > 0){
            arr1[i] = '0';
            i++;
            count--;
        }
        while (i < 8){
            arr1[i] = str1.charAt(i-count2);
            i++;
        }
        return arr1;
    }
    public  char[] convertToBitmix(char[] arr1,char[] arr2,char[] arr3){
        char arrR[] = new char[24];
        int i = 0;
        int j = 0;
        while (i < 24){
            arrR[i] = arr1[j];
            arrR[i + 1] = arr2[j];
            arrR[i + 2] = arr3[j];
            j++;
            i = i + 3;
        }
        return arrR;


    }

    public BMX(){}
}
