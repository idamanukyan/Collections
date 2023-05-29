package com.company.deque;

import java.util.NoSuchElementException;

public class Deque {
    NodeDeque head;
    NodeDeque tail;

    public void addFirst(int element) {
        NodeDeque newNode = new NodeDeque(element);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(int element) {
        NodeDeque newNode = new NodeDeque(element);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }

        int removedElement = head.value;
        head = head.next;

        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // The deque is empty after removing the only element
        }

        return removedElement;
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }

        int removedElement = tail.value;
        tail = tail.prev;

        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // The deque is empty after removing the only element
        }

        return removedElement;
    }

    public int peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }

        return head.value;
    }

    public int peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }

        return tail.value;
    }

    public int removeFirstOccurrence(int element) {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }

        NodeDeque current = head;
        while (current != null) {
            if (current.value == element) {
                if (current == head) {
                    return removeFirst();
                } else if (current == tail) {
                    return removeLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    return current.value;
                }
            }
            current = current.next;
        }

        throw new NoSuchElementException("Element not found in deque");
    }

    public int removeLastOccurrence(int element) {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }

        NodeDeque current = tail;
        while (current != null) {
            if (current.value == element) {
                if (current == tail) {
                    return removeLast();
                } else if (current == head) {
                    return removeFirst();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    return current.value;
                }
            }
            current = current.prev;
        }

        throw new NoSuchElementException("Element not found in deque");
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        NodeDeque current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
