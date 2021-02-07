package com.codegym.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {

    //fields
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    //constructor
    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }

    //set/get
    public int getCourse() {
        return course;
    }

    public void setCourse(int course){
        this.course = course;
    }

    public void setAverageGrade(double averageGrade){
        this.averageGrade = averageGrade;
    }

    public void setBeginningOfSession(Date date){
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }


    //
    public void live() {
        learn();
    }

    public void learn() {
    }

    public void incAverageGrade(double delta){
        double temporaryAverageGrade = getAverageGrade();
        temporaryAverageGrade += delta;
        setAverageGrade(temporaryAverageGrade);
    }

    @Override
    public String getPosition() {
        return "Student";
    }
}