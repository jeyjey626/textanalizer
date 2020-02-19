package com.jmakulec.textanalyzer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class WordSlicerTest {

    @Test
    public void SliceToSyllables(){
        ArrayList<String> result = WordSlicer.sliceWord("alabama");
        assertEquals(Arrays.asList("a", "la", "ba", "ma"), result);
    }

    @Test
    public void SliceToSyllables1(){
        ArrayList<String> result = WordSlicer.sliceWord("przeczenie");
        assertEquals(Arrays.asList("prze", "cze", "ni", "e"), result);
    }

    @Test
    public void SliceToSyllables2(){
        ArrayList<String> result = WordSlicer.sliceWord("kLopocik");
        assertEquals(Arrays.asList("kLo", "po", "ci", "k"), result);
    }

    @Test
    public void SliceToSyllablesa(){
        ArrayList<String> result = WordSlicer.sliceWord("klopocik");
        assertEquals(Arrays.asList("klo", "po", "ci", "k"), result);
    }

    @Test
    public void SliceToSyllables3(){
        ArrayList<String> result = WordSlicer.sliceWord("brAboZny");
        assertEquals(Arrays.asList("brA", "bo", "Zny"), result);
    }
}
