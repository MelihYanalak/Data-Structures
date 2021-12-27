package com.company;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class NLP
{
    private ArrayList<String> fileNames = new ArrayList<String >();
    private ArrayList<Double> termNums = new ArrayList<Double>();
    private Word_Map wmap;
    /*You should not use File_Map class in this file since only word hash map is aware of it.
    In fact, you can define the File_Map class as a nested class in Word_Map,
     but for easy evaluation we defined it separately.
     If you need to access the File_Map instances, write wrapper methods in Word_Map class.
    * */

    /*Reads the dataset from the given dir and created a word map */
    public NLP(){
        wmap = new Word_Map();
    }
    public  void readDataset(String dir)throws FileNotFoundException {
        File folder = new File(dir);
        for (final File fileEntry : folder.listFiles()) {
            //System.out.print(dir + "  " + fileEntry.getName());
            readFile(dir,fileEntry.getName());
        }

    }
    private void readFile(String dir,String fileName) throws FileNotFoundException {
        int currentNum = 0;
        File f = new File(dir+"\\"+fileName);
        Scanner s = new Scanner(f);
        while (s.hasNextLine()){
            if (!s.hasNext()){
                break;
            }
            String temp = s.next();
            temp = temp.trim().replaceAll("\\p{Punct}", "");

            if (!temp.equals("")) {
                if (wmap.containsKey(temp)) {
                    wmap.get(temp).put(fileName, currentNum);
                } else {
                    wmap.put(temp);
                    wmap.get(temp).put(fileName, currentNum);
                }
                currentNum++;
            }
        }
        fileNames.add(fileName);
        termNums.add((double)currentNum);

    }


    /*Finds all the bigrams starting with the given word*/
    public List<String> bigrams(String word){
        ArrayList<String> result = new ArrayList<>();
        for (String s : (HashSet<String>)wmap.get(word).keySet()){

            for (Integer i : wmap.get(word).get(s)){
                if (!result.contains(word + " " + wmap.veryHelperMethod(s,i+1))) {
                    result.add(word + " "+ wmap.veryHelperMethod(s, i+1));
                }
            }

        }
        return result;

    }


    /*Calculates the tfIDF value of the given word for the given file */
    public float tfIDF(String word, String fileName) {
        double wordNumInFile = wmap.get(word).get(fileName).size();

        double TF = (double)(wordNumInFile) / (double)(termNums.get(fileNames.indexOf(fileName)));
        double IDF = (double) fileNames.size() / (double)wmap.get(word).size();
        IDF = Math.log(IDF);
        return (float) (TF * IDF);
    }

    /*Print the WordMap by using its iterator*/
    public  void printWordMap()
    {
        for (entry e : (HashSet<entry>)wmap.entrySet()){
            System.out.print(e.getKey()+" --> ");
            for (String s : (HashSet<String>)e.getValue().keySet()){
                System.out.print("FileName: "+s + "   List "+e.getValue().get(s) +" " );
            }
            System.out.println("\n");
        }

    }

}
