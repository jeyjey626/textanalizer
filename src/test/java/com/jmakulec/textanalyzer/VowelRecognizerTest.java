package com.jmakulec.textanalyzer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import static org.junit.Assert.*;

public class VowelRecognizerTest {

    @Test
    public void checkVowels(){

        //given
        ArrayList<String> vowelList = new ArrayList<>(Arrays.asList("a", "A", "e", "E", "i", "o", "O", "u", "y"));
        Random random = new Random();

        //when
        boolean tested = VowelRecognizer.isVowel(vowelList.get(random.nextInt(vowelList.size())));

        assertTrue(tested);
    }

    @Test
    public void detectConsonant(){
        assertFalse(VowelRecognizer.isVowel("b"));
    }

    @Test
    public void ignoreSyllables(){
        assertFalse(VowelRecognizer.isVowel("aa"));
    }

}
