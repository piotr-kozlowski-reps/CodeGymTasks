package com.codegym.task.task23.task2311;

/* 
Repeating threads

*/

//Repeating threads
//Make it so that only methods of the Solution class are called in the someActions method.
//
//Expected output in the main method:
//
//Amigo: Mmmmm, beef
//Amigo: knock knock
//Amigo: Zzzzzzz...1 s
//
//Requirements:
//1. The screen output must match the task conditions.
//2. In the someActions method, the Solution class's sleep method must be called.
//3. The Solution class must have a name field.
//4. The Solution class must have a food field.
//5. The Solution class must have a sound field.


public class Solution {
    public final String name;
    public final String food;
    public final String sound;

    public Solution(String name, String food, String sound) {
        this.name = name;
        this.food = food;
        this.sound = sound;
    }

    public void eat() {
        System.out.println(name + ": Mmmmm, " + food);
    }

    public void play() {
        System.out.println(name + ": " + sound + " " + sound);
    }

    public void sleep(long milliseconds) {
        System.out.println(name + ": Zzzzzzz..." + (milliseconds / 1000) + " s");
    }

    public void live() throws InterruptedException {
        Thread thread = new Thread() {
            public void run() {
                try {
                    someActions();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void someActions() throws InterruptedException {
                eat();
                play();
                Solution.this.sleep(1000);
            }
        };
        thread.start();
        thread.join();
    }

    public static void main(String[] args) throws InterruptedException {
        new Solution("Amigo", "beef", "knock").live();
    }
}
