package com.company.stack;

public class Stack {

    private int size;
    private int[] stack;

    public Stack() {
        this.size = 0;
        this.stack = new int[10];
    }

    private void resize() {
        int[] newStack = new int[size * 2];
        if (stack.length == size) {
            for (int i = 0; i < size; i++) {
                newStack[i] = stack[i];
            }
        }
        stack = newStack;
    }

    public void push(int element) {
        resize();
        stack[size] = element;
        size++;
    }

    public int x() {
        if (isEmpty()) {
            return -1;
        }
        int element = stack[size];
        size--;
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return stack[size];
    }

    public int isPresent(int element) {
        for (int i = 0; i < size; i++) {
            if (stack[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public int getElement(int element) {
        return stack[isPresent(element)];
    }

    public int getElementFromIndex(int index) {
        return stack[index];
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
