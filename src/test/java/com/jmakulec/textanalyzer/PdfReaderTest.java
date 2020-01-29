package com.jmakulec.textanalyzer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDPageLabelRange;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class PdfReaderTest {

    @Test
    public void readDocument(){
        String test = PdfReader.readText("E:\\Dokumenty\\PracaInz\\docs\\exampledoc.pdf");

        assertEquals("Przykładowy dokument\n" +
                " \n" +
                "Gdubum miał gitare to bym na niej grał\n",
                test);
    }

}
