package com.jmakulec.textanalyzer;

import java.util.ArrayList;

public class WordSlicer {
    public static ArrayList<String> sliceWord(String input) {

        String workable;
        int stopPoint = 0;
        int startPoint = 0;
        int pointer = 0;
        ArrayList<String> workableArrayList = new ArrayList<>();


        while (stopPoint < input.length()){
            if(VowelRecognizer.isVowel(String.valueOf(input.charAt(stopPoint)))) {
                if (stopPoint - startPoint == 0){workableArrayList.add(String.valueOf(input.charAt(stopPoint)));}
                else if(stopPoint == input.length() -1){
                    workable = input.substring(startPoint);
                    workableArrayList.add(workable);
                }
                else {
                    workable = input.substring(startPoint, stopPoint +1);
                    workableArrayList.add(workable);
                }
                stopPoint++;
                startPoint = stopPoint;


            }
            else {
                stopPoint ++;
                if(stopPoint == input.length()){
                    if (stopPoint - startPoint == 1){workableArrayList.add(String.valueOf(input.charAt(stopPoint -1)));}
                    else{
                        workable = input.substring(startPoint);
                        workableArrayList.add(workable);
                    }
                }
            }
        }



        return workableArrayList;
    }
}
