package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter the path of input file");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Thread1 t1 = new Thread1(input);
        t1.start();

        //C:\Users\Dell\Desktop\example.png




    }


}
