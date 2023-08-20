package com.marsmission.core.enumeration;

public enum Orientation {

    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    Orientation(String key) {
        this.key = key;
    }

    private String key;

    public String getKey() {
        return key;
    }
}