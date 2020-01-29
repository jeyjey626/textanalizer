package com.jmakulec.textanalyzer;

import lombok.Data;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Data
public class PdfReader {


    private static String myPath = "E:\\Dokumenty\\PracaInz\\docs\\";

    public static PDDocument document;

    private static String text;


    public static String readText(String userPath){
        try {
            document = PDDocument.load(new File(userPath));
            PDFTextStripper pdfStripper = new PDFTextStripper();
            text = pdfStripper.getText(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
