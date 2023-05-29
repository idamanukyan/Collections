package com.company.deque;

public class NodeDeque {
    int value;
    NodeDeque next;
    NodeDeque prev;

    public NodeDeque(int value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
