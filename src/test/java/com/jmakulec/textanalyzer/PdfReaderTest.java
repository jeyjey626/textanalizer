package com.jmakulec.textanalyzer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDPageLabelRange;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PdfReaderTest {

    @Test
    public void sliceDocument(){
        ArrayList<String> test = PdfReader.readText(new File("E:\\Dokumenty\\PracaInz\\docs\\exampledoc.pdf"));

        System.out.println(test);
        assertEquals(Arrays.asList("przykLadowy", "dokumencik", "Lojeju"),
                test);
    }

}
