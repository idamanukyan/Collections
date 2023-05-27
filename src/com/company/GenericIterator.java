package com.company;

public interface GenericIterator<T> {

    boolean hasNext();

    T next();

    void remove();

}
