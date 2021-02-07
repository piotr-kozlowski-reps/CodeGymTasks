package pl.codegym.task.task13.task1328;

/* 
Walki robotów
*/

public class Solution {
    public static void main(String[] args) {
        Robot amigo = new Robot("Amigo");
        Robot enemy = new Robot("Wróg");

        doMove(amigo, enemy);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(amigo, enemy);
    }

    public static void doMove(Robot robotFirst, Robot robotSecond) {
        BodyPart attacked = robotFirst.attack();
        BodyPart defended = robotFirst.defend();
        System.out.println(String.format("%s zaatakował %s: zaatakowano jego %s i zdołano obronić jego %s",
                robotFirst.getName(), robotSecond.getName(), attacked, defended));
    }
}
