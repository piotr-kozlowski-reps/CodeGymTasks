package com.codegym.task.task35.task3513;

public class MoveFitness implements Comparable<MoveFitness>{

    //fields
    private int numberOfEmptyTiles;
    private int score;
    private Move move;
    
    //const
    public MoveFitness(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    //set/get
    public Move getMove() {
        return move;
    }


    //
    @Override
    public int compareTo(MoveFitness o) {

        if (numberOfEmptyTiles != o.numberOfEmptyTiles){
            if (numberOfEmptyTiles > o.numberOfEmptyTiles) return 1;
            else return -1;
        } else if (score != o.score) {
            if (score > o.score) return 1;
            else return -1;
        } else return 0;


    }
}
