package com.company;

import java.util.Arrays;

public class myArrayList {
    private Pixel[] data;
    int size;


    public myArrayList(){
        data = new Pixel[0];
        size = 0;

    }
    public boolean add(Pixel input){
        data = Arrays.copyOf(data,size+1);
        data[size] = input;
        size++;
        return true;
    }
    public int size(){
        return size;
    }
    public Pixel get(int index){
        return data[index];
    }
    public void set(int index,Pixel input){
        data[index] = input;
    }
    public Pixel remove(int index){
        Pixel temp = data[index];
        if (index == size-1){
            size--;

        }
        else {
            while (index < size){
                data[index] = data[index+1];
                index++;
            }
            size--;

        }
        return temp;
    }
}
