package com.company.map;

public class MapNode {
    String key;
    Integer value;
    MapNode left;
    MapNode right;

    public MapNode(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

}
