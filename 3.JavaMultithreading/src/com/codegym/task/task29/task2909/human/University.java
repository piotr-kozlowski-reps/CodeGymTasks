package com.codegym.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class University{

    //fields
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;


    //constructor(s)
    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }


    //set/get
    public void setStudents(List<Student> students){
        this.students = students;
    }

    public List<Student> getStudents(){
        return students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    //
    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student : students){
            if (student.getAverageGrade() == averageGrade) return student;
        }
        return null;
    }

    public Student getStudentWithHighestAverageGrade() {

        Student studentWithHighestAverageGrade = students.get(0);

        for (Student studentFromList : students){
            if (studentFromList.getAverageGrade() > studentWithHighestAverageGrade.getAverageGrade()){
                studentWithHighestAverageGrade = studentFromList;
            }
        }

        return studentWithHighestAverageGrade;
    }

    public Student getStudentWithLowestAverageGrade(){

        Student studentWithLowestAverageGrade = students.get(0);

        for (Student studentFromList : students){
            if (studentFromList.getAverageGrade() < studentWithLowestAverageGrade.getAverageGrade()){
                studentWithLowestAverageGrade = studentFromList;
            }
        }

        return studentWithLowestAverageGrade;
    }

    public void expel(Student student){

        ListIterator<Student> studentsListIterator = students.listIterator();
        while (studentsListIterator.hasNext()){
            if(studentsListIterator.next().equals(student)) studentsListIterator.remove();
        }

    }
}