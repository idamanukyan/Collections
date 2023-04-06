package com.company;

public class ArrayList {

    int[] initialArray = new int[8];
    int filledSize = 0;

    private void ensureCapacity() {
        if (filledSize == initialArray.length) {
            int[] newArray = new int[initialArray.length * 2];
            initialArray = clone(initialArray, newArray);
        }
    }

    public void add(int element) {
        ensureCapacity();
        initialArray[filledSize] = element;
        filledSize++;
    }

    public void addAll(int[] array) {
        for (int j : array) {
            add(j);
        }
        filledSize = filledSize + array.length;
    }

    public void add(int index, int element) {
        ensureCapacity();
        int[] newArray = new int[filledSize + 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = initialArray[i];
        }
        newArray[index] = element;
        for (int i = index + 1; i <= filledSize; i++) {
            newArray[i] = initialArray[i - 1];
        }
        initialArray = newArray;
        filledSize++;
    }

    public void removeAll() {
        for (int i = 0; i < filledSize; i++) {
            initialArray[i] = 0;
        }
        filledSize = 0;
    }

    public void removeElementOfIndex(int index) {
        for (int i = index; i < filledSize - 1; i++) {
            initialArray[i] = initialArray[i + 1];
        }
        filledSize--;
    }

    public void removeElement(int element) {
        for (int i = 0; i < initialArray.length; i++) {
            if (initialArray[i] == element) {
                removeElementOfIndex(i);
                filledSize--;
            }
        }
        System.out.println("The element does not exist.");
    }

    public int getElement(int index) {
        return initialArray[index];
    }

    public int getIndex(int element) {
        for (int i = 0; i < filledSize; i++) {
            if (initialArray[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return filledSize == 0;
    }

    public int size() {
        return filledSize;
    }

    public int[] clone(int[] array, int[] newArray) {
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public int[] subList(int start, int end) {
        int[] newArray = new int[end - start + 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = initialArray[i + start];
        }
        return newArray;
    }

    public void print() {
        for (int i = 0; i < filledSize; i++) {
            System.out.println(initialArray[i]);
        }
    }
}
