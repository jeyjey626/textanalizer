package com.jmakulec.textanalyzer;

import java.io.File;
import java.util.*;

public class Main {


    public static void main(String[] args){

        HashMap<String, Double> syllablesMap = new HashMap<>();

        String myPath = "E:\\Dokumenty\\PracaInz\\docs\\";
        ArrayList<String> wordsFromPDF = PdfReader.readText(new File(myPath + "potop.pdf"));
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
        double maxValue = Collections.max(syllablesMap.values());
        System.out.println("max value = " + maxValue );


    }
}
