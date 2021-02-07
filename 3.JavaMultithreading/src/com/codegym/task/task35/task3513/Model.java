package com.codegym.task.task35.task3513;

import java.io.File;
import java.util.*;

public class Model {

    //fields
    private final static int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;
    private Stack<Tile[][]> previousStates;
    private Stack<Integer> previousScores;
    private boolean isSaveNeeded = true;

    //constr
    public Model() {
        resetGameTiles();
        this.score = 0;
        this.maxTile = 0;
        this.previousStates = new Stack<>();
        this.previousScores = new Stack<>();
    }

    //get/set
    public Tile[][] getGameTiles() {
        return gameTiles;
    }



    //
    public void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++){
            for (int j = 0; j < FIELD_WIDTH; j++){
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> emptyTilesList = getEmptyTiles();

        if (!emptyTilesList.isEmpty()) {

            int randomNumberUpToEmptyTilesListSize = (int) (Math.random() * emptyTilesList.size() % emptyTilesList.size());
            Tile tileToFill = emptyTilesList.get(randomNumberUpToEmptyTilesListSize);
            tileToFill.setValue(Math.random() < 0.9 ? 2 : 4);
        }

    }
    
    private List<Tile> getEmptyTiles() {

        List<Tile> emptyTilesList = new ArrayList<>();

        for (int i = 0; i < gameTiles.length; i++){
            for (int j = 0; j < gameTiles[i].length; j++){

                Tile excactTile = gameTiles[i][j];
                if (excactTile.isEmpty()) emptyTilesList.add(excactTile);
            }
        }

        return emptyTilesList;

    }

    private int getEmptyTilesNumber(Tile[][] tilesArray) {
        return tilesArray.length;
    }

    private boolean consolidateTiles(Tile[] tiles) {
        int insertPosition = 0;
        boolean result = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (!tiles[i].isEmpty()) {
                if (i != insertPosition) {
                    tiles[insertPosition] = tiles[i];
                    tiles[i] = new Tile();
                    result = true;
                }
                insertPosition++;
            }
        }
        return result;
    }

    private boolean mergeTiles(Tile[] tiles) {

        boolean wasArrayChanged = false;

        for (int i = 0; i < tiles.length - 1; i++) {

            int valueBaseTile = tiles[i].getValue();
            int valueNextTile = tiles[i + 1].getValue();

            if ( valueBaseTile != 0 || valueNextTile != 0){

                if (valueBaseTile == valueNextTile) {
                    wasArrayChanged = true;
                    tiles[i].setValue(tiles[i].getValue() * 2);
                    int newValueOfTileMerged = tiles[i].getValue();
                    tiles[i + 1].setValue(0);
                    this.score += newValueOfTileMerged;
                    if (newValueOfTileMerged > this.maxTile) this.maxTile = newValueOfTileMerged;
                    i += 1;
                }

            }
            
        }

        consolidateTiles(tiles);
        return wasArrayChanged;

    }

    public void up() {

        saveState(gameTiles);

        boolean wasConsolidated = false;
        boolean wasMerged = false;

        //rotate array 3 times to have it heading UP
        gameTiles = rotateArrayClockWise(gameTiles);
        gameTiles = rotateArrayClockWise(gameTiles);
        gameTiles = rotateArrayClockWise(gameTiles);


        for (Tile[] tilesRaw : gameTiles) {
            wasConsolidated = consolidateTiles(tilesRaw);
            wasMerged =  mergeTiles(tilesRaw);
        }

        if (wasConsolidated || wasMerged) {
            addTile();
        }

        //rotate array once more to have it heading in right direction
        gameTiles = rotateArrayClockWise(gameTiles);

    }

    public void down() {

        saveState(gameTiles);

        boolean wasConsolidated = false;
        boolean wasMerged = false;

        //rotate array once to have it heading RIGHT
        gameTiles = rotateArrayClockWise(gameTiles);

        for (Tile[] tilesRaw : gameTiles) {
            wasConsolidated = consolidateTiles(tilesRaw);
            wasMerged =  mergeTiles(tilesRaw);
        }

        if (wasConsolidated || wasMerged) {
            addTile();
        }

        //rotate array 3 times to have it heading in right direction back
        gameTiles = rotateArrayClockWise(gameTiles);
        gameTiles = rotateArrayClockWise(gameTiles);
        gameTiles = rotateArrayClockWise(gameTiles);

    }

    public void right() {

        saveState(gameTiles);

        boolean wasConsolidated = false;
        boolean wasMerged = false;

        //rotate array 2 times to have it heading RIGHT
        gameTiles = rotateArrayClockWise(gameTiles);
        gameTiles = rotateArrayClockWise(gameTiles);


        for (Tile[] tilesRaw : gameTiles) {
            wasConsolidated = consolidateTiles(tilesRaw);
            wasMerged =  mergeTiles(tilesRaw);
        }

        if (wasConsolidated || wasMerged) {
            addTile();
        }

        //rotate array twice more to have it heading in right direction back
        gameTiles = rotateArrayClockWise(gameTiles);
        gameTiles = rotateArrayClockWise(gameTiles);

    }

    public void left() {

        if (isSaveNeeded) saveState(gameTiles);

        boolean wasConsolidated = false;
        boolean wasMerged = false;

        for (Tile[] tilesRaw : gameTiles) {
            wasConsolidated = consolidateTiles(tilesRaw);
            wasMerged =  mergeTiles(tilesRaw);
        }

        if (wasConsolidated || wasMerged) {
            addTile();
        }

        isSaveNeeded = true;

    }

    private Tile[][] rotateArrayClockWise(Tile[][] arrayMatrix) {
        int size = arrayMatrix.length;
        Tile[][] rotatedArray = new Tile[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotatedArray[i][j] = arrayMatrix[size - j - 1][i];
            }
        }
        return rotatedArray;
    }

    private boolean isFull() {
        return getEmptyTiles().size() == 0;
    }

    public boolean canMove() {

        if (!isFull()) {
            return true;
        }

        for (int x = 0; x < FIELD_WIDTH; x++) {
            for (int y = 0; y < FIELD_WIDTH; y++) {

                Tile tile = gameTiles[x][y];

                if (x < FIELD_WIDTH - 1 && tile.getValue() == gameTiles[x + 1][y].getValue()
                        || y < FIELD_WIDTH - 1 && tile.getValue() == gameTiles[x][y + 1].getValue()) {
                    return true;
                }

            }
        }

        return false;


    }

    private void saveState(Tile[][] actualGameTiles) {

        //create new copy of Array
        Tile[][] temporaryGameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int x = 0; x < FIELD_WIDTH; x++) {
            for (int y = 0; y < FIELD_WIDTH; y++) {
                Tile tile = actualGameTiles[x][y];
                temporaryGameTiles[x][y] = new Tile(tile.getValue());
            }
        }

        //create new copy of Integer? Do I must do it? I have no idea
        Integer temporaryScore = new Integer(score);

        this.previousStates.push(temporaryGameTiles);
        this.previousScores.push(temporaryScore);
        this.isSaveNeeded = false;
    }

    public void rollback() {

        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            this.gameTiles = previousStates.pop();
            this.score = previousScores.pop();
        }

    }

    public void randomMove() {
        int pseudoRandomInt = ((int) (Math.random() * 100)) % 4;

        switch (pseudoRandomInt) {
            case 0:
                left();
                break;
            case 1:
                up();
                break;
            case 2:
                right();
                break;
            case 3:
                down();
                break;
        }

    }

    public boolean hasBoardChanged() {

        boolean hasChanged = false;

        Tile[][] lastGameStateFromStack = previousStates.peek();
        for (int x = 0; x < FIELD_WIDTH; x++) {
            for (int y = 0; y < FIELD_WIDTH; y++) {
                if (gameTiles[x][y].value != lastGameStateFromStack[x][y].value) hasChanged = true;
            }
        }

        return hasChanged;
    }

    private MoveFitness getMoveFitness(Move move) {

        MoveFitness moveFitness = new MoveFitness(-1, 0, move);
        move.move();

        if (hasBoardChanged()) {
            moveFitness = new MoveFitness(getEmptyTiles().size(), score, move);
        }

        rollback();
        return moveFitness;

    }

    public void autoMove() {

        PriorityQueue<MoveFitness> queue = new PriorityQueue(4, Collections.reverseOrder());
        queue.offer(getMoveFitness(this::left));
        queue.offer(getMoveFitness(this::up));
        queue.offer(getMoveFitness(this::right));
        queue.offer(getMoveFitness(this::down));

        queue.peek().getMove().move();

    }


    public static void main(String[] args) {

/*        //todo: wywal potem
        Model model = new Model();
        Tile[] temporaryArray = new Tile[4];
        temporaryArray[0] = new Tile(4);
        temporaryArray[1] = new Tile(2);
        temporaryArray[2] = new Tile(0);
        temporaryArray[3] = new Tile(0);
//        model.consolidateTiles(temporaryArray);
        model.mergeTiles(temporaryArray);
        System.out.println(temporaryArray);*/

/*        int[][] testArray = {
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4},
        };

        printMatrix(testArray);

        int[][] arrayRotated = model.rotateArrayClockWise(testArray);

        printMatrix(arrayRotated);*/


    }

}