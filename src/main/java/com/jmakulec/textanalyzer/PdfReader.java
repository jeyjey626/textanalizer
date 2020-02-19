package com.jmakulec.textanalyzer;

import lombok.Data;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import sun.nio.cs.UTF_8;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class PdfReader {




    public static PDDocument document;

    private static String text;


    public static ArrayList<String> readText(File file, String encoding){
        try {
            document = PDDocument.load(file);
            PDFTextStripper pdfStripper = new PDFTextStripper();
            text = pdfStripper.getText(document);
            text = text.toLowerCase();
            text = text.replaceAll("\u0105", "A");
            text = text.replaceAll("\u0119", "E");
            text = text.replaceAll("\u0107", "C");
            text = text.replaceAll("\u0142", "L");
            text = text.replaceAll("\u0144", "N");
            text = text.replaceAll("\u00f3", "O");
            text = text.replaceAll("\u015b", "S");
            text = text.replaceAll("\u017a", "X");
            text = text.replaceAll("\u017c", "Z");

            System.out.println(text);

        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] words = text.split("\\W+");
        return (ArrayList<String>) Arrays.stream(words).collect(Collectors.toList());
    }
}
