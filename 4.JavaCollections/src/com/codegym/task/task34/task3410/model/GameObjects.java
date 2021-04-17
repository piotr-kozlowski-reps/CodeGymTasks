package com.codegym.task.task34.task3410.model;

import java.util.HashSet;
import java.util.Set;

public class GameObjects {

    //fields
    Set<Wall> walls;
    Set<Box> boxes;
    Set<StorageLocation> storageLocations;
    Player player;

    //constr
    public GameObjects(Set<Wall> walls, Set<Box> boxes, Set<StorageLocation> storageLocations, Player player) {
        this.walls = walls;
        this.boxes = boxes;
        this.storageLocations = storageLocations;
        this.player = player;
    }

    //set/get
    public Set<Wall> getWalls() {
        return walls;
    }
    public Set<Box> getBoxes() {
        return boxes;
    }
    public Set<StorageLocation> getStorageLocations() {
        return storageLocations;
    }
    public Player getPlayer() {
        return player;
    }


    //
    public Set<GameObject> getAll() {
        Set<GameObject> gameObjectSet = new HashSet<>();
        gameObjectSet.addAll(getWalls());
        gameObjectSet.addAll(getBoxes());
        gameObjectSet.addAll(getStorageLocations());
        gameObjectSet.add(player);

        return gameObjectSet;
    }


}