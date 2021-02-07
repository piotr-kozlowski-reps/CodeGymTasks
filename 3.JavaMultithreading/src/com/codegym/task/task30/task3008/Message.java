package com.codegym.task.task30.task3008;

import java.io.Serializable;

public class Message implements Serializable {

    //fields
    private final MessageType type;
    private final String data;

    //constructors
    public Message(MessageType type) {
        this.type = type;
        data = null;
    }

    public Message(MessageType type, String data) {
        this.type = type;
        this.data = data;
    }

    // get/set
    public MessageType getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}