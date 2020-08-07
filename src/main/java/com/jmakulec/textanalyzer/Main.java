package com.jmakulec.textanalyzer;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
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

        Comparator<Map.Entry<String, Double>> valueComp = new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                Double v1 = o1.getValue();
                Double v2 = o2.getValue();
                return v2.compareTo(v1);
            }
        };

        Set<Map.Entry<String, Double>> entrySet = syllablesMap.entrySet();

        ArrayList<Map.Entry<String, Double>> topSyllables = new ArrayList<Map.Entry<String, Double>>(entrySet);
        topSyllables.sort(valueComp);



        //for(int i = 0; i < 100; i++) System.out.println(topSyllables.get(i).getKey());

        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Najczęściej użyte sylaby");

        int rownum = 0;
        for (Map.Entry<String, Double> entry : topSyllables)
        {
            Row row = sheet.createRow(rownum++);
            int cellnum = 0;
            Cell cell = row.createCell(cellnum++);
            cell.setCellValue(entry.getKey());
            Cell secondCell = row.createCell(cellnum++);
            secondCell.setCellValue(entry.getValue());
            if (topSyllables.indexOf(entry) == 0) {
                setAnalysis(row, 50, topSyllables);
            }
            else if (topSyllables.indexOf(entry) == 1) {
                setAnalysis(row, 100, topSyllables);
            }
            else if (topSyllables.indexOf(entry) == 2) {
                setAnalysis(row, 150, topSyllables);
            }
            else if (topSyllables.indexOf(entry) == 3) {
                setAnalysis(row, 200, topSyllables);
            }
            else if (topSyllables.indexOf(entry) == 4) {
                setAnalysis(row, 250, topSyllables);
            }
            else if (topSyllables.indexOf(entry) == 5) {
                setAnalysis(row, 300, topSyllables);
            }
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("topsyllables.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }





    }

    private static void setAnalysis(Row row, int firstX, ArrayList<Map.Entry<String, Double>> topSyllables) {
        int cellnum = 3;
        double first100 = topSyllables.stream().filter(e -> topSyllables.indexOf(e) < firstX).mapToDouble(Map.Entry::getValue).sum();
        double all = topSyllables.stream().mapToDouble(Map.Entry::getValue).sum();
        double percentage = first100 / all *100;
        Cell analysis = row.createCell(cellnum++);
        analysis.setCellValue(first100);
        Cell analysis2 = row.createCell(cellnum++);
        analysis2.setCellValue(all);
        Cell analysis3 = row.createCell(cellnum++);
        analysis3.setCellValue(percentage);
    }
}
