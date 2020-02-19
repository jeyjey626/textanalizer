package com.jmakulec.textanalyzer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args){

        HashMap<String, Double> syllablesMap = new HashMap<>();

        String myPath = "E:\\Dokumenty\\PracaInz\\docs\\";
        ArrayList<String> wordsFromPDF = PdfReader.readText(new File(myPath + "wiersze.pdf"));
        wordsFromPDF.forEach(s -> {
            ArrayList<String> tempSyllables = WordSlicer.sliceWord(s);
            tempSyllables.forEach(s1 -> {
                if (syllablesMap.containsKey(s1)){
                    double oldValue = syllablesMap.get(s1);
                    syllablesMap.replace(s1, oldValue +1);
                }
                else{
                    syllablesMap.put(s1, (double) 1);
                }
            });
        });

        Set<String> printable = syllablesMap.keySet();
        System.out.println(printable.size());


    }
}
