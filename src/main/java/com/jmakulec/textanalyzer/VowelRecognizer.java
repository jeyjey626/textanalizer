package com.jmakulec.textanalyzer;


import java.util.Arrays;
import java.util.HashSet;

public class VowelRecognizer {

    private static final HashSet<String> vowelSet = new HashSet<>(Arrays.asList("a", "A", "e", "E", "i", "o", "O", "u", "y"));
    static boolean isVowel(String s){
        return vowelSet.contains(s);
    }
}
