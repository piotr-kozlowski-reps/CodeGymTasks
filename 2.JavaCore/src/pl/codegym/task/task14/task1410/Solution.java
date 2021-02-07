package pl.codegym.task.task14.task1410;

/* 
Degustacja win
*/

public class Solution {
    public static void main(String[] args) {
        getDeliciousDrink().taste();
        System.out.println(getWine().getCelebrationName());
        System.out.println(getBubblyWine().getCelebrationName());
        System.out.println(getWine().getCelebrationName());
    }

    public static Drink getDeliciousDrink() {
        Drink wino = new Wine();
        return wino;
    }

    public static Wine getWine() {
        Wine wino = new Wine();
        return wino;
    }

    public static Wine getBubblyWine() {
        Wine winoMusujace = new BubblyWine();
        return winoMusujace;
    }
}
