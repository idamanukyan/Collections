package com.company.stack;

import com.company.GenericIterator;

public class StackIterator implements GenericIterator {
    private int currentIndex;
    private boolean removable;
    private Stack stack;

    public StackIterator() {
        this.currentIndex = stack.size();
        this.removable = false;
    }

    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            return null;
        }
        removable = true;
        return stack.getElement(currentIndex--);
    }

    @Override
    public void remove() {
        if (!removable) {
            return;
        }
        for (int i = currentIndex + 1; i <= stack.size(); i++) {
            stack.getStack()[i - 1] = stack.getStack()[i];
        }
        int size = stack.size();
        size--;
        currentIndex--;
        removable = false;
    }
}

