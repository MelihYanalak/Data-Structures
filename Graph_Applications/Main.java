package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        matrixGraph mg = fillGraph("input.txt");
        mg.makeTransitive();
        System.out.println(mg.findNum());

    }

    public static matrixGraph fillGraph(String fileName) throws IOException {
        BufferedReader bf;
        bf = new BufferedReader(new FileReader(fileName));
        String line = bf.readLine();
        String[] array = line.split(" ");
        matrixGraph mg = new matrixGraph(true,Integer.parseInt(array[0]));
        line = bf.readLine();
        while (line != null && line != "" ){
            String[] tempArray = line.split(" ");
            mg.addRelation(Integer.parseInt(tempArray[0]),Integer.parseInt(tempArray[1]));
            line = bf.readLine();
        }
        bf.close();
        return mg;



    }
}
