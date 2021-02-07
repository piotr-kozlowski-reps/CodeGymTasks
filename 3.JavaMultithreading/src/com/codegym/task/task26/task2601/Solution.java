package com.codegym.task.task26.task2601;

/* 
Read online about the median of a sample

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    private HelperClass helperClass;
    private static List<HelperClass> helperClasses = new ArrayList<>();
    private static double median;


    public static void main(String[] args) {

//        Integer[] exampleIntigersArray = new Integer[]{5000, 6000, 4000, 7000, 8000, 7500, 10000, 12000, 4500, 1000000};
//        Integer[] exampleIntigersArray = new Integer[]{19, 20, 10, 0 , 1};
//        sort(exampleIntigersArray);


    }

    public static Integer[] sort(Integer[] array) {

        median = countMedian(array);

        //fill HelperClass list
        for (int i = 0; i < array.length; i++){
            addNewHelperObjectsIfNeeded(array[i]);
        }

        //sort by distance from median
        Collections.sort(helperClasses);

        //propagate list with digits from HelperClass
        List<Integer> resultList = propagateListFromHelperClassObjects();

        Integer[] resultArray = resultList.toArray(new Integer[0]);
        return resultArray;
    }

    private static double countMedian(Integer[] array){

        List<Integer> temporaryArrayList = Arrays.asList(array);
        Collections.sort(temporaryArrayList);
        double median = 0;

        if (temporaryArrayList.size() % 2 != 0) {
           median = temporaryArrayList.get((int) Math.round((temporaryArrayList.size() + 1) / 2) - 1);
        } else {
            int firstIndex = ((temporaryArrayList.size() + 1) / 2) - 1;
            int secondIndex = (temporaryArrayList.size() + 1) / 2;
            median = (temporaryArrayList.get(firstIndex) + temporaryArrayList.get(secondIndex)) / 2.0;
        }

        return median;
    }

    private static void addNewHelperObjectsIfNeeded(Integer arrayItem){

        boolean isThereDigitWithTheSameDistanceInList = false;

        double distanceFromMedian = arrayItem - median;
        if (distanceFromMedian < 0) distanceFromMedian = -distanceFromMedian;

        for (HelperClass everyHelperClass : helperClasses){
            if (everyHelperClass.getDistanceFromMedian() == distanceFromMedian) isThereDigitWithTheSameDistanceInList = true;
        }

        if (!isThereDigitWithTheSameDistanceInList){
            List<Integer> digitsWithTheSameDistance = new ArrayList<>();
            digitsWithTheSameDistance.add(arrayItem);
            helperClasses.add(new HelperClass(distanceFromMedian, digitsWithTheSameDistance));
        }
        else {
            for (HelperClass everyHelperClass : helperClasses){
                if (everyHelperClass.getDistanceFromMedian() == distanceFromMedian){
                    List<Integer> digitsWithTheSameDistanceGetFromHelperClass = everyHelperClass.getDigitsWithTheSameDistanceFromMedian();
                    digitsWithTheSameDistanceGetFromHelperClass.add(arrayItem);
                    Collections.sort(digitsWithTheSameDistanceGetFromHelperClass);
                    everyHelperClass.setDigitsWithTheSameDistanceFromMedian(digitsWithTheSameDistanceGetFromHelperClass);
                }
            }
        }
    }

    private static List<Integer> propagateListFromHelperClassObjects() {
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < helperClasses.size(); i++){
            HelperClass individualHelperClass = helperClasses.get(i);
            for (int j = 0; j < individualHelperClass.getDigitsWithTheSameDistanceFromMedian().size(); j++){
                resultList.add(individualHelperClass.getDigitsWithTheSameDistanceFromMedian().get(j));
            }
        }



        return resultList;
    }


}
