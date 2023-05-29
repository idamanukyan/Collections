package com.company.map;

public class TreeMap {

    private MapNode root;

    public void put(String key, Integer value) {
        root = putNode(root, key, value);
    }

    private MapNode putNode(MapNode node, String key, Integer value) {
        if (node == null) {
            return new MapNode(key, value);
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = putNode(node.left, key, value);
        } else if (cmp > 0) {
            node.right = putNode(node.right, key, value);
        } else {
            node.value = value;
        }

        return node;
    }

    public Integer get(String key) {
        MapNode node = getNode(root, key);
        return (node != null) ? node.value : null;
    }

    private MapNode getNode(MapNode node, String key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            return getNode(node.left, key);
        } else if (cmp > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }

    public void remove(String key) {
        root = removeNode(root, key);
    }

    private MapNode removeNode(MapNode node, String key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = removeNode(node.left, key);
        } else if (cmp > 0) {
            node.right = removeNode(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            MapNode successor = findMinNode(node.right);
            node.key = successor.key;
            node.value = successor.value;
            node.right = removeNode(node.right, successor.key);
        }

        return node;
    }

    private MapNode findMinNode(MapNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public boolean containsKey(String key) {
        return getNode(root, key) != null;
    }
}
