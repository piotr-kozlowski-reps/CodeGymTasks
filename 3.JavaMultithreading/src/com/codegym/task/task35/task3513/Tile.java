package com.codegym.task.task35.task3513;

import java.awt.*;

public class Tile {

    //fields
    int value;

    //constr
    public Tile(int value) {
        this.value = value;
    }

    public Tile() {
        this.value = 0;
    }

    //get/set
    public boolean isEmpty() {
        if (this.value == 0) return true;
        else return false;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    //
    public Color getFontColor() {
        if (this.value < 16) return new Color(0x776e65);
        else return new Color(0xf9f6f2);
    }

    public Color getTileColor() {
        if (this.value == 0) return new Color(0xcdc1b4);
        else if (this.value == 2) return new Color(0xeee4da);
        else if (this.value == 4) return new Color(0xede0c8);
        else if (this.value == 8) return new Color(0xf2b179);
        else if (this.value == 16) return new Color(0xf59563);
        else if (this.value == 32) return new Color(0xf67c5f);
        else if (this.value == 64) return new Color(0xf65e3b);
        else if (this.value == 128) return new Color(0xedcf72);
        else if (this.value == 256) return new Color(0xedcc61);
        else if (this.value == 512) return new Color(0xedc850);
        else if (this.value == 1024) return new Color(0xedc53f);
        else if (this.value == 2048) return new Color(0xedc22e);
        else return new Color(0xFF0000);
    }


}
