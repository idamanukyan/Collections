package com.company.arrayList;

import java.util.NoSuchElementException;

public class ArrayListIterator<T> {

    private T[] array;
    private int index;
    private boolean canRemove;

    public ArrayListIterator(T[] array) {
        this.array = array;
        this.index = 0;
        this.canRemove = false;
    }

    public boolean hasNext() {
        return index < array.length;
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T element = array[index];
        index++;
        canRemove = true;
        return element;
    }

    public void remove() {
        if (!canRemove) {
            throw new IllegalStateException();
        }
        int removeIndex = index - 1;
        for (int i = removeIndex; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = null;
        index--;
        canRemove = false;
    }
}
