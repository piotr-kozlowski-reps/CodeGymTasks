package com.codegym.task.task29.task2909.human;

public class UniversityPerson extends Human{

    //fields
    private University university;


    //contructor
    public UniversityPerson(String name, int age){
        super(name, age);
    }


    //set/get
    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

}
