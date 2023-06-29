package com.company.queue;

import java.util.Deque;

public class Queue {

    private int first;
    private int last;
    private int[] queueArray;
    private int size;

    public Queue() {
        this.size = 0;
        this.first = 0;
        this.last = -1;
        this.queueArray = new int[10];
    }

    private void resize() {
        int[] newQueue = new int[size * 2];
        if (queueArray.length == size) {
            for (int i = 0; i < size; i++) {
                newQueue[i] = queueArray[i];
            }
        }
    }

    public void add(int element) {
        resize();
        last = (last + 1) % size;
        queueArray[last] = element;
    }

    public void remove() {
        if (!isEmpty()) {
            int item = queueArray[first];
            first = (first + 1) % size;
        }
    }

    public boolean isEmpty() {
        return (last == -1);
    }

    public int poll() {
        if (isEmpty()) {
            return -1;
        }
        return queueArray[first];
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        if (last >= first) {
            return last - first + 1;
        } else {
            return size - first + last + 1;
        }
    }

}
