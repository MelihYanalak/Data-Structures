package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        NLP nlp = new NLP();
        nlp.readDataset("C:\\Users\\Dell\\Desktop\\DATA STRUCTURES\\HW6\\HW06\\dataset");
        youKnowWhatToDo("input.txt",nlp);

    }










    public static void youKnowWhatToDo(String filename,NLP deneme) throws FileNotFoundException{
        File f = new File(filename);
        Scanner s = new Scanner(f);
        while (s.hasNextLine()){
            if (!s.hasNext()){
                break;
            }
            String temp = s.next();
            if (temp.equals("bigram")){
                System.out.println(deneme.bigrams(s.next()));
                System.out.println();
            }
            else if(temp.equals("tfidf")){
                System.out.println(deneme.tfIDF(s.next(),s.next()));
                System.out.println();
            }
        }


    }
}
