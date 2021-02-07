package com.codegym.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{

    //fields
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    private List<Human> children = new ArrayList<>();
    public Size size;
    private BloodType bloodType;

    //constructor/s
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Human> getChildren(){
        return Collections.unmodifiableList(children);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setBloodType(BloodType bloodType){
        this.bloodType = bloodType;
    }

    public BloodType getBloodType() {
        return bloodType;
    }



    //
    public void addChild(Human child){
        children.add(child);
    }

    public void removeChild(Human child){
        children.remove(child);
    }

    public void live() {
    }

    public String getPosition(){
        return "Person";
    }

    public void printData(){
        System.out.println(getPosition() + ": " + name);
    }

    public void printSize() {
        System.out.println("Height: " + size.getHeight() + " Weight: " + size.getWeight());
    }


    public class Size {

        //fields
        public int height;
        public int weight;

        //constructors
        public Size(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        //set/get
        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

}