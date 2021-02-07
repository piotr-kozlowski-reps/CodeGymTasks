package com.codegym.task.task29.task2909.human;

public class Worker extends Human{

    //fields
    private double salary;
    private String company;

    //constructor/s
    public Worker(String name, int age) {
        super(name, age);
    }

    //set/get
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    //
    public void live(){
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}