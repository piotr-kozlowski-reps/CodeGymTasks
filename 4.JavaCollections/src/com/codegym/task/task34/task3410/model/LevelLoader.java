package com.codegym.task.task34.task3410.model;



import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {

    public LevelLoader(Path levels) {
    }

    public GameObjects getLevel(int level) {

        Set<Wall> walls = new HashSet<>();
        walls.add(new Wall(30, 30));
        walls.add(new Wall(30, 50));
        walls.add(new Wall(30, 70));
        walls.add(new Wall(10, 10));

        Set<Box> boxes = new HashSet<>();
        boxes.add(new Box(100, 100));

        Set<StorageLocation> storageLocations = new HashSet<>();
        storageLocations.add(new StorageLocation(90, 90));

        Player player = new Player(90, 110);



        return new GameObjects(walls, boxes, storageLocations, player);
    }
}