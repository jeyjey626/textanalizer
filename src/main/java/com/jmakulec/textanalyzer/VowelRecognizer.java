package com.jmakulec.textanalyzer;


import java.util.Arrays;
import java.util.HashSet;

public class VowelRecognizer {

    private static HashSet<String> vowelSet = new HashSet<>(Arrays.asList("a", "ą", "e", "ę", "i", "o", "ó", "u", "y"));
    static boolean isVowel(String s){
        return vowelSet.contains(s);
    }
}
