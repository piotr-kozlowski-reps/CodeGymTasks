package com.codegym.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses){
        this.horses = horses;
    }

    public List<Horse> getHorses(){
        return horses;
    }

    public static void main(String[] args) {

        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(new Horse("horse1", 3, 0));
        game.getHorses().add(new Horse("horse2", 3, 0));
        game.getHorses().add(new Horse("horse3", 3, 0));

        game.run();
        game.printWinner();
    }
    
    public void run(){

        for (int i = 0; i < 100; i++){
            move();
            print();
            try{
                Thread.sleep(200);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }

    public void move(){
        for (Horse horseIterated : horses){
            horseIterated.move();
        }
    }

    public void print(){
        for (Horse horseIterated : horses){
            horseIterated.print();
        }

        for (int i = 0; i < 10; i++){
            System.out.println();
        }

    }

    public Horse getWinner(){
        Horse winner = null;
        int whichIndexIsBest = 1;
        double distanceToBeCompared = horses.get(1).getDistance();
        for (int i = 0; i < horses.size(); i++){
            if (horses.get(i).getDistance() > distanceToBeCompared){
                whichIndexIsBest = i;
                distanceToBeCompared = horses.get(i).getDistance();
            }
        }
        winner = horses.get(whichIndexIsBest);

        return winner;
    }

    public void printWinner(){
        String winnerToBePrinted = String.format("The winner is %s!", getWinner().getName());
        System.out.println(winnerToBePrinted);
    }

}