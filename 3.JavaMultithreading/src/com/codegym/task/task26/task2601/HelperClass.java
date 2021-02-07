package com.codegym.task.task26.task2601;

import java.util.List;

public class HelperClass implements Comparable<HelperClass> {

    //fields
    private double distanceFromMedian;
    private List<Integer> digitsWithTheSameDistanceFromMedian;

    //constructors
    public HelperClass(double distanceFromMedian, List<Integer> digitsWithTheSameDistanceFromMedian){
        this.distanceFromMedian = distanceFromMedian;
        this.digitsWithTheSameDistanceFromMedian = digitsWithTheSameDistanceFromMedian;
    }

    // set/ge
    public double getDistanceFromMedian() {
        return distanceFromMedian;
    }

    public void setDistanceFromMedian(double distanceFromMedian) {
        this.distanceFromMedian = distanceFromMedian;
    }

    public List<Integer> getDigitsWithTheSameDistanceFromMedian() {
        return digitsWithTheSameDistanceFromMedian;
    }

    public void setDigitsWithTheSameDistanceFromMedian(List<Integer> digitsWithTheSameDistanceFromMedian) {
        this.digitsWithTheSameDistanceFromMedian = digitsWithTheSameDistanceFromMedian;
    }

    @Override
    public String toString() {
        return "HelperClass{" +
                "distanceFromMedian=" + distanceFromMedian +
                ", digitsWithTheSameDistanceFromMedian=" + digitsWithTheSameDistanceFromMedian +
                '}';
    }

    @Override
    public int compareTo(HelperClass o) {
        return (int) Math.round(this.getDistanceFromMedian() - o.getDistanceFromMedian());
    }
}
